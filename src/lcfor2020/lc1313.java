package lcfor2020;

public class lc1313 {
    public int[] decompressRLElist(int[] nums) {
        int len=0;
        for (int i=0;i<nums.length;++i){
            if (i%2==0){
                len+=nums[i];
            }
        }
        int[] res=new int[len];
        int index=0;
        for (int i=0;i<nums.length/2;++i){
            for (int j=0;j<nums[i*2];++j){
                res[index++]=nums[i*2+1];
            }
        }
        return res;
    }
}
