package lcfor2020.contest204;

import java.util.Arrays;

public class c1 {
    public static boolean containsPattern(int[] arr, int m, int k) {
        int[] a=new int[m];
        for (int i = 0; i < arr.length - m; i++) {
            a= Arrays.copyOfRange(arr,i,i+m);
            int kCount=k-1;
            for (int j = i+m; j < arr.length; j+=m) {
                int[] b=Arrays.copyOfRange(arr,j,j+m);
                boolean flag=true;
                for (int l = 0; l < m; l++) {
                    if (a[l]!=b[l]){
                        flag=false;
                    }
                }
                if (flag){
                    kCount--;
                    if (kCount==0){
                        return true;
                    }
                    a=b;
                }else {
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        containsPattern(new int[]{1,2,1,2,1,1,1,3},2,2);
    }
}
