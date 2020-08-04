package lcfor2020;

public class lc1480 {
    public int[] runningSum(int[] nums) {
        int sum=0;
        int[] res=new int[nums.length];
        for (int i=0;i<nums.length;++i){
            sum+=nums[i];
            res[i]+=sum;
        }
        return res;
    }
}
