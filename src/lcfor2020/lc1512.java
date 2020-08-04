package lcfor2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc1512 {
    public int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        List<Integer> l=new ArrayList<>();
        int count=1;
        for (int i=1;i<nums.length;++i){
            if (nums[i]==nums[i-1]){
                count++;
            }else {
                if (count>0){
                    l.add(count);
                    count=1;
                }else {
                    continue;
                }
            }
        }
        if (count>1){
            l.add(count);
        }
        int res=0;
        for (int i=0;i<l.size();++i){
            res+=(l.get(i))*(l.get(i)-1)/2;
        }
        return res;
    }
}
