package lcfor2020.contest205;

import java.util.Arrays;

public class c2 {
    public static int numrTiplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int count=0;
        boolean needOut=false;
        for (int i = 0; i < nums1.length; i++) {
            long num1=(long)nums1[i]*(long)nums1[i];
            needOut=false;
            for (int j = 0; j < nums2.length; j++) {
                for (int k = j+1; k < nums2.length; k++) {
                    if ((long)nums2[j]*(long)nums2[k]==num1){
                        count++;
                    }else if ((long)nums2[j]*(long)nums2[k]>num1){
                      needOut=true;
                      break;
                    }
                }
            }
        }
        needOut=false;
        for (int i = 0; i < nums2.length; i++) {
            long num1=(long)nums2[i]*(long)nums2[i];
            needOut=false;
            for (int j = 0; j < nums1.length; j++) {
                for (int k = j+1; k < nums1.length; k++) {
                    if ((long)nums1[j]*(long)nums1[k]==num1){
                        count++;
                    }else if ((long)nums1[j]*(long)nums1[k]>num1){
                        needOut=true;
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        numrTiplets(new int[]{1,3,1,2},new int[]{2,3,5,3,2});//2??
    }
}
