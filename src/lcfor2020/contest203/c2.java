package lcfor2020.contest203;

import java.util.Arrays;

public class c2 {//5496
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum=0;
        int term=piles.length/3;
        int count=0;
        for (int i = piles.length-1; count<term; i-=2) {
            sum+=piles[i];
            count++;
        }
        return sum;
    }
}
