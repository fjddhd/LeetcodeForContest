package lcfor2020;

import java.math.BigInteger;

public class Offer14_1 {
    public int cuttingRope(int n) {
        int max=Integer.MIN_VALUE;
        for (int i=1;i<n;++i){
            int all=i,ntemp=n;
            while (ntemp>0){
                if (ntemp-i>i+1){
                    all*=i;
                }else {
                    all*=(ntemp-i);
                    break;
                }
                ntemp-=i;
            }
            max=Math.max(max,all);
        }
        return max;
    }
}
