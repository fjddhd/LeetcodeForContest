package lcfor2020;

import java.util.ArrayList;
import java.util.List;

public class lc1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> lres=new ArrayList<>();
        int maxValue=Integer.MIN_VALUE;
        for (int i:candies){
            maxValue=Math.max(maxValue,i);
        }
        int threshold=maxValue-extraCandies;
        for (int i=0;i<candies.length;++i){
            if (candies[i]>=threshold){
                lres.add(true);
            }else {

                lres.add(false);
            }
        }
        return lres;
    }
}
