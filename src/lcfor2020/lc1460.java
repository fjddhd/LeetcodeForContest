package lcfor2020;

import java.util.*;

public class lc1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for (int i:arr){
            if (hm.containsKey(i)){
                hm.put(i,hm.get(i)+1);
            }else {
                hm.put(i,1);
            }
        }
        for (int i:target){
            if (hm.containsKey(i)){
                if (hm.get(i)>1){
                    hm.put(i,hm.get(i)-1);
                }else {
                    hm.remove(i);
                }
            }else {
                return false;
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = hm.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue()!=0){
                return false;
            }
        }
        return true;


    }

    public boolean canBeEqual1(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i=0;i<target.length;++i){
            if (target[i]!=arr[i]){
                return false;
            }
        }
        return true;
    }
}
