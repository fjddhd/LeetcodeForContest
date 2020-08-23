package lcfor2020.contest203;

import java.util.ArrayList;
import java.util.List;

public class c3 {//5497
    public int findLatestStep(int[] arr, int m) {//单例超时
        int res=-1;
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <arr.length; i++) {
            sb.append(0);
        }
        for (int i = 0; i <arr.length ; i++) {
            sb.replace(arr[i]-1,arr[i],"1");
            String[] split = sb.toString().split("0+");
            for (int j=0;j<split.length;++j){
                if (split[j].length()==m){
                    res=i+1;
                    continue;
                }
            }
        }
        return res;
    }
    public static int findLatestStep1(int[] arr, int m) {//单例不超时，整体超时
        int res=-1;
        if (arr.length==m){
            return m;
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <arr.length; i++) {
            sb.append(1);
        }
        for (int i = arr.length-1; i >=0 ; i--) {
            sb.replace(arr[i]-1,arr[i],"0");
            String[] split = sb.toString().split("0+");
            for (int j=0;j<split.length;++j){
                System.out.println("i:"+i+"--- j:"+j+"  长度："+split[j].length());
                if (split[j].length()==m){
                    res=i;
                    break;
                }
            }
            if (res!=-1){
                break;
            }
        }
        return res;
    }
    public static int findLatestStep2(int[] arr, int m) {//单例不超时，整体超时
        int res=-1;
        if (arr.length==m){
            return m;
        }
        List<Integer> LL=new ArrayList<>();
        for (int i = 0; i <arr.length; i++) {
            LL.add(5);
        }
        for (int i = arr.length-1; i >=0 ; i--) {
            //-TODO 树

            if (res!=-1){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        findLatestStep1(new int[]{3,5,1,2,4},1);
    }
}
