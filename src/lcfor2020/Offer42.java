package lcfor2020;

public class Offer42 {//ͬinterview 1716
    public int maxSubArray(int[] nums) {
        int count=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <nums.length; i++) {
            count+=nums[i];
            max=Math.max(max,count);
            if (count<=0){
                count=0;
            }
        }
        return max;
    }
}
