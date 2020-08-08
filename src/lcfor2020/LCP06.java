package lcfor2020;

public class LCP06 {
    public int minCount(int[] coins) {
        int minTerm=0;
        for (int a:coins){
            minTerm+=a/2+(a%2==1?1:0);
        }
        return minTerm;
    }
}
