package lcfor2020;
/**
 * https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
 * duo-dong
 * */
public class lc1299 {
    public int[] replaceElements(int[] arr) {
        int max=Integer.MIN_VALUE;
        int[] out=new int[arr.length];
        out[arr.length-1]=-1;
        max=Math.max(max,arr[arr.length-1]);
        for (int i=arr.length-2;i>=0;--i){
            out[i]=max;
            if (arr[i]<max){
            }else {
                max=Math.max(max,arr[i]);
            }
        }
        return out;
    }
}
