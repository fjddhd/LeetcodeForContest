package lcfor2020;

public class lc1304 {
    public int[] sumZero(int n) {
        int[] a_=new int[n];
        for (int i=0;i<n/2;++i){
            a_[i]=-(i+1);
            a_[n/2+i]=i+1;
        }
        if (n%2==1){
            a_[n-1]=0;
        }
        return a_;
    }
}
