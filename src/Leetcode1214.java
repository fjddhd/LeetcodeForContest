import java.util.ArrayList;
import java.util.List;

public class Leetcode1214 {
    public int findSpecialInteger(int[] arr) {
        int max=-999999;
        for (int i:arr){
            max=Math.max(i,max);
        }
        int[] a=new int[max+1];
        for (int i:arr){
            a[i]++;
        }
        for (int i=0;i<a.length;++i){
            if (a[i]>(0.25*arr.length)){
                return i;
            }
        }
        return 0;
    }
    public int getDecimalValue(ListNode head) {
        StringBuilder sb=new StringBuilder();
        while (head!=null){
            sb.append(head.val);
            head=head.next;
        }
        int sum=0;
        StringBuilder reverse = sb.reverse();
        System.out.println(reverse);
        for (int i=0;i<reverse.length();++i){
            sum+=(reverse.charAt(i)-48)*Math.pow(2,i);
        }
        return sum;
    }
    public List<Integer> sequentialDigits(int low, int high) {
        int[] a={12,23,34,45,56,67,78,89,
        123,234,345,456,567,678,789,
        1234,2345,3456,4567,5678,6789,
        12345,23456,34567,45678,56789,
        123456,234567,345678,456789,
        1234567,2345678,3456789,
        12345678,23456789,
        123456789};
        List<Integer> L=new ArrayList<>();
        for (int i:a){
            if (i>=low && i<=high){
                L.add(i);
            }
        }
        return L;
    }
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length,n=mat[0].length;
        int size=Math.min(m,n);
        ArrayList<ArrayList<Integer>> L=new ArrayList<>();
        ArrayList<Integer> LL=new ArrayList<>();
        LL.add(0);
        for (int c=0;c<=size;++c){
            L.add(new ArrayList<>());
        }
        for (int a=0;a<m;++a){
            for (int b=0;b<n;++b){
                for (int c=1;c<=size;++c){
                    int temp = countSq(mat, a, b, c);
                    if (temp==-1){
                        continue;
                    }
                    L.get(c).add(temp);
                }
            }
        }
        for (int c=1;c<L.size();++c){
            int min=999999999;
            ArrayList<Integer> al = L.get(c);
            for (int i=0;i<al.size();++i){
                min=Math.min(min,al.get(i));
            }
            LL.add(min);
        }
        for (int c=LL.size()-1;c>0;--c){
            if (LL.get(c)<=threshold){
                return c;
            }
        }
        return 0;
    }
    public int countSq(int[][] mat,int i,int j,int size){
        int m=mat.length,n=mat[0].length;
        int count=-1;
        if (i+size<=m && j+size<=n){
            count++;
            for (int a=i;a<i+size;++a){
                for (int b=j;b<j+size;++b){
                    count+=mat[a][b];
                }
            }
        }
        return count;
    }
}
