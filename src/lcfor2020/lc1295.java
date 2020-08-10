package lcfor2020;

public class lc1295 {
    public int findNumbers(int[] nums) {
        int res=0,bit;
        for (int i=0;i<nums.length;++i){
            bit=0;
            while (nums[i]>0){
                bit++;
                nums[i]/=10;
            }
            if (bit%2==0){
                res++;
            }
        }
        return res;
    }
}
