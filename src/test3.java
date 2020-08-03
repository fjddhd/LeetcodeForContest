import java.util.Arrays;

public class test3 {
    public int maximumSum(int[] arr) {
        return Math.max(aaaa(arr),bbb(arr));
    }
    public int aaaa(int[] arr){
        int countOfminus=0,sum=0,max=Integer.MIN_VALUE;
        int minus1=0,minus2=0;
        int count=0;
        for (int i=0;i<arr.length;++i){
            max=Math.max(max,arr[i]);
            if (countOfminus>=2 || sum-minus1+arr[i]<0 && minus1!=0){
                sum=0;
                countOfminus=0;
                minus1=0;
                minus2=0;
                count=0;
                continue;
            }
            sum+=arr[i];
            count++;

            if (arr[i]<0){
                if (minus1==0){
                    minus1=arr[i];
                    countOfminus=1;
                }else {
                    if (minus2==0 && sum-minus1+arr[i]>=0){
                        minus2=arr[i];
                        countOfminus=2;
                    }
                }

            }
        }
        if (count==0){
            return max;
        }
        else  if (count==1){
            if (minus1!=0){
                return max;
            }else {
                return Math.max(max,sum);
            }
        }else {
            return Math.max(max,sum-minus1);
        }
    }
    public int bbb(int[] arr){
        int countOfminus=0,sum=0,max=Integer.MIN_VALUE;
        int minus1=0,minus2=0;
        int count=0;
        for (int i=arr.length-1;i>=0;--i){
            max=Math.max(max,arr[i]);
            if (countOfminus>=2 || sum-minus1+arr[i]<0 && minus1!=0){
                sum=0;
                countOfminus=0;
                minus1=0;
                minus2=0;
                count=0;
                continue;
            }
            sum+=arr[i];
            count++;

            if (arr[i]<0){
                if (minus1==0){
                    minus1=arr[i];
                    countOfminus=1;
                }else {
                    if (minus2==0 && sum-minus1+arr[i]>=0){
                        minus2=arr[i];
                        countOfminus=2;
                    }
                }

            }
        }
        if (count==0){
            return max;
        }
        else  if (count==1){
            if (minus1!=0){
                return max;
            }else {
                return Math.max(max,sum);
            }
        }else {
            return Math.max(max,sum-minus1);
        }
    }
}
