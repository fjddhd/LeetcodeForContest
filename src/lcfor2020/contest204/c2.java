package lcfor2020.contest204;

public class c2 {
    public int getMaxLen(int[] nums) {
        int maxCount=-1;
        int count=0;
        int minusCount=0;
        boolean sei=true;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp>0){
                if (sei) {
                    count++;
                    maxCount=Math.max(maxCount,count);
                }else {
                    minusCount++;
                }
            }else if (temp==0){
                count=0;
                sei=true;
                minusCount=0;
            }else {
                if (sei){
                    sei=!sei;
                    minusCount=count+1;
                }else {
                    sei=!sei;
                    count=minusCount+1;
                    minusCount=0;
                    maxCount=Math.max(maxCount,count);
                }
            }
        }
        maxCount=Math.max(0,maxCount);
        count=0;
        minusCount=0;
        sei=true;
        for (int i = nums.length-1; i >=0; i--) {
            int temp = nums[i];
            if (temp>0){
                if (sei) {
                    count++;
                    maxCount=Math.max(maxCount,count);
                }else {
                    minusCount++;
                }
            }else if (temp==0){
                count=0;
                sei=true;
                minusCount=0;
            }else {
                if (sei){
                    sei=!sei;
                    minusCount=count+1;
                }else {
                    sei=!sei;
                    count=minusCount+1;
                    minusCount=0;
                    maxCount=Math.max(maxCount,count);
                }
            }
        }
        return maxCount;
    }
}
