package lcfor2020;

import java.util.Arrays;

/**
 *https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence/
 * */
public class lc1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int minus=arr[1]-arr[0];
        for(int i=2;i<arr.length;++i){
            int minus2=arr[i]-arr[i-1];
            if(minus2!=minus){
                return false;
            }
        }
        return true;
    }
}
