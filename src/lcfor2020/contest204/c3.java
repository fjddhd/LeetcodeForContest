package lcfor2020.contest204;

import java.util.*;

public class c3 {

    public static int minDays(int[][] grid) {
        int countDay=0;
        HashMap<Integer,List<Integer>> LL=new HashMap<>();//最大900,1~900
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1){
                    List<Integer> L=new ArrayList<>();
                    if (j>0 && grid[i][j-1]==1){
                        L.add(i*grid[0].length+j);
                    }
                    if (i>0 && grid[i-1][j]==1){
                        L.add((i-1)*grid[0].length+j+1);
                    }
                    if (j<grid[0].length-1 && grid[i][j+1]==1){
                        L.add(i*grid[0].length+j+2);
                    }
                    if (i<grid.length-1 && grid[i+1][j]==1){
                        L.add((i+1)*grid[0].length+j+1);
                    }
                    LL.put(i*grid[0].length+j+1,L);
                }
            }
        }
        int day=0;
        while (true) {//-TODO 这个是把分离成单位小岛，原题只要非连通即可
            Iterator<Map.Entry<Integer, List<Integer>>> iterator = LL.entrySet().iterator();
            int maxsize=1,maxsizeKey=0;
            while (iterator.hasNext()){
                Map.Entry<Integer, List<Integer>> next = iterator.next();
                int size = next.getValue().size();
                if (size>maxsize){
                    maxsizeKey=next.getKey();
                    maxsize=size;
                }
            }
            LL.remove(maxsizeKey);
            HashMap<Integer,List<Integer>> hm=new HashMap<>(LL);
            if (maxsize>1){
                Iterator<Map.Entry<Integer, List<Integer>>> iterator1 = LL.entrySet().iterator();
                while (iterator1.hasNext()){
                    Map.Entry<Integer, List<Integer>> next1 = iterator1.next();
                    List<Integer> value = next1.getValue();
                    if (value.contains(new Integer(maxsizeKey))){
                        value.remove(new Integer(maxsizeKey));
                        hm.put(next1.getKey(),value);
                    }
                }
                day++;
                LL=hm;
            }else {
                break;
            }
        }
        return day;
    }
    public static void main(String[] args) {
        minDays(new int[][]{{0,1,1,0},{0,1,1,0},{0,0,0,0}});
    }
}
