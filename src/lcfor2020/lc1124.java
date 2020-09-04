package lcfor2020;

import java.util.HashMap;
import java.util.Map;

public class lc1124 {
    public static int longestWPI(int[] hours) {//³¬Ê±
        int outerMax=0;
        int max=0;
        int i;
        for (i = 0; i < hours.length; i++) {
            int count=hours[i]>8?1:-1;
            if (count>0) {
                max=1;
            }else {
                max=0;
            }
            for (int j = i+1; j < hours.length; j++) {
                count+=hours[j]>8?1:-1;
                if (count>0){
                    max=Math.max(max,j-i+1);
                }else if (count==0){
//                    max=Math.max(max,j-i);
                }
            }
            outerMax=Math.max(outerMax,max);
        }
        return outerMax;


    }
    public static int ooo(int[] hours){
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        for(int i = 0; i < hours.length; i++){
            int temp = hours[i] > 8 ? 1 : -1;
            sum += temp;
            System.out.println(sum);
            if(sum > 0)
                res = i + 1;
            else {
                if(!sumToIndex.containsKey(sum))
                    sumToIndex.put(sum, i);
                if(sumToIndex.containsKey(sum - 1))
                    res = Math.max(res, i - sumToIndex.get(sum - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int res=ooo(new int[]{9,9,6,0,6,6,9});//3
        //1,2,1,0,-1,-2,-1
        int res=ooo(new int[]{8,12,7,6,10,10});//10
//        int res=longestWPI(new int[]{10,5,9,7,9,9,5,5,7,10});//7
//        int res=longestWPI(new int[]{7,9,7,9,7,9,7,9,7});//7
//        int res=longestWPI(new int[]{7,9,7,9,7,9,7,9,9});//9
//        int res=longestWPI(new int[]{6,6,9});//1
        System.out.println(res);
    }
}
