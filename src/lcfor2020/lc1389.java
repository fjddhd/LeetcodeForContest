package lcfor2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> l=new ArrayList<>();
        for (int i=0;i<nums.length;++i){
            l.add(index[i],nums[i]);
        }
        return ListToArray(l);
    }
    public static int[] ListToArray(List<Integer> L){
        int[] a=new int[L.size()];
        for (int i=0;i<L.size();++i){
            a[i]=L.get(i);
        }
        return a;
    }
}
