package lcfor2020;

public class lc1486 {
    public int xorOperation(int n, int start) {
        int xor=start;
        int sum=start;
        for (int i=1;i<n;++i){
            sum+=2;
            xor=xor^sum;
        }
        return xor;
    }
}
