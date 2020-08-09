package lcfor2020;

import java.util.Arrays;
import java.util.HashMap;

public class lc1365 {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res=new int[nums.length];
        int[] a= Arrays.copyOf(nums,nums.length);
        Arrays.sort(a);
        HashMap<Integer,Integer> hm=new HashMap<>();
        for (int i=0;i<a.length;++i){
            if (!hm.containsKey(a[i])) {
                hm.put(a[i],i);
            }
        }
        for (int i=0;i<nums.length;++i){
            res[i]=hm.get(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        smallerNumbersThanCurrent(new int[]{8,1,2,2,3});
    }
}
