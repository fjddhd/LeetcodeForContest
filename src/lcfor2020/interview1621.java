package lcfor2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class interview1621 {
    public static int[] findSwapValues(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int sum1=0,sum2=0;
        List<Integer> listSet1=new ArrayList<>();
        List<Integer> listSet2=new ArrayList<>();
        if (array1.length>0){
            listSet1.add(array1[0]);
        }
        if (array2.length>0){
            listSet2.add(array2[0]);
        }
        for (int i=0;i<array1.length;++i){
            sum1+=array1[i];
            if (i>0 && array1[i]!=array1[i-1]){
                listSet1.add(array1[i]);
            }
        }
        for (int i=0;i<array2.length;++i){
            sum2+=array2[i];
            if (i>0 && array2[i]!=array2[i-1]){
                listSet2.add(array2[i]);
            }
        }
        int minus=sum1-sum2;
        if (Math.abs(minus)%2==1){
            return new int[0];
        }
        int[] res=new int[2];
        for (int i=0;i<listSet1.size();++i){
            for (int j=0;j<listSet2.size();++j){
                //-TODO ÓÅ»¯µã
                if (listSet2.get(j)+minus/2==listSet1.get(i)){
                    res[0]=listSet1.get(i);
                    res[1]=listSet2.get(j);
                    return res;
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        findSwapValues(new int[]{1,2,3},new int[]{4,5,6});
    }
}
