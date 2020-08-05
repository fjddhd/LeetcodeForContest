package lcfor2020;

public class lc1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] res=new int[n*2];
        int t=0;
        for (int i=0;i<n;++i){
            int a=nums[i];
            int b=nums[n+i];
            res[t++]=a;
            res[t++]=b;
        }
        return res;
    }
}
