package lcfor2020.contest203;

import java.util.ArrayList;
import java.util.List;

public class c3 {//5497
    public int findLatestStep(int[] arr, int m) {//������ʱ
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
    public static int findLatestStep1(int[] arr, int m) {//��������ʱ�����峬ʱ
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
                System.out.println("i:"+i+"--- j:"+j+"  ���ȣ�"+split[j].length());
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
    public static int findLatestStep2(int[] arr, int m) {//��������ʱ�����峬ʱ
        int res=-1;
        if (arr.length==m){
            return m;
        }
        List<Integer> LL=new ArrayList<>();
        for (int i = 0; i <arr.length; i++) {
            LL.add(5);
        }
        for (int i = arr.length-1; i >=0 ; i--) {
            //-TODO ��

            if (res!=-1){
                break;
            }
        }
        return res;
    }

    /**
     * ���Բο����нⷨ
     * https://leetcode-cn.com/problems/find-latest-group-of-size-m/solution/on-de-jie-jue-fang-fa-by-time-limit/
     * ���Ҷ��� 0����ʱ��λ����Ϊ �����ζ������ڡ�
     * ������߻����ұߡ���ʱ��λ�� �Ὣĳ���ɶεĳ��ȼ� 1��
     * ���Ҷ��� 1����ʱ ��λ�ûὫ�����ɶκϲ���һ���¶Ρ�
     * */
    public static int findLatestStep3(int[] arr, int m) {//���ɳ�ʱ
        int[] asist=new int[arr.length+2];//asist[i]Ϊ����Ϊi��1�Ӷε�����
        int lastM=-1;//��¼m�����Ӷ�Ϊ0�����һ��
        int[] myString=new int[arr.length+2];
        for (int i = 0; i < arr.length; i++) {
            int temp=arr[i];
            myString[temp]=1;
            if (myString[temp-1]==0 && myString[temp+1]==0){
                int pre=asist[m];

                asist[1]++;

                if (pre>0 && asist[m]==0){
                    lastM=i;
                }
                if (i==arr.length-1 && asist[m]>0){
                    lastM=arr.length;
                }
            }else if (myString[temp-1]==0 && myString[temp+1]==1){
                int tempIndex=temp+1,count=0;
                while (true){
                    if (myString[tempIndex]==1){
                        count++;
                        tempIndex++;
                    }else {
                        break;
                    }
                }
                int pre=asist[m];

                asist[count]--;
                asist[count+1]++;

                if (pre>0 && asist[m]==0){
                    lastM=i;
                }
                if (i==arr.length-1 && asist[m]>0){
                    lastM=arr.length;
                }
            }else if (myString[temp-1]==1 && myString[temp+1]==0){
                int tempIndex=temp-1,count=0;
                while (true){
                    if (myString[tempIndex]==1){
                        count++;
                        tempIndex--;
                    }else {
                        break;
                    }
                }
                int pre=asist[m];

                asist[count]--;
                asist[count+1]++;

                if (pre>0 && asist[m]==0){
                    lastM=i;
                }
                if (i==arr.length-1 && asist[m]>0){
                    lastM=arr.length;
                }
            }else {//����ȫ1
                int tempIndex1=temp-1,count1=0;
                while (true){
                    if (myString[tempIndex1]==1){
                        count1++;
                        tempIndex1--;
                    }else {
                        break;
                    }
                }
                int tempIndex2=temp+1,count2=0;
                while (true){
                    if (myString[tempIndex2]==1){
                        count2++;
                        tempIndex2++;
                    }else {
                        break;
                    }
                }
                int pre=asist[m];

                asist[count1]--;
                asist[count2]--;
                asist[count1+count2+1]++;

                if (pre>0 && asist[m]==0){
                    lastM=i;
                }
                if (i==arr.length-1 && asist[m]>0){
                    lastM=arr.length;
                }
            }
        }
        return lastM;

    }

    public static int findLatestStep4(int[] arr, int m) {//ĳ���
        int n = arr.length;
        int[] c = new int[n + 1];//
        int ans = -1, cnt = 0;//cntΪ����Ϊm���Ӷθ���
        for (int i = 0; i < n; ++i) {
            int cur = arr[i];//curÿ��ѭ������Ҫ��1��λ��
            c[cur] = 1;
            int l = c[cur - 1];
            if (l > 0) {//
                if (l == m) --cnt;
                c[cur] += l;
                c[cur - l] = c[cur];
            }
            if (cur + 1 <= n && c[cur + 1] > 0) {//����
                if (c[cur + 1] == m) --cnt;
                c[cur] += c[cur + 1];
                c[cur + c[cur + 1]] = c[cur];
                if (c[cur - l] > 0) c[cur - l] = c[cur];
            }
            if (c[cur] == m) ++cnt;
            if (cnt > 0) ans = i + 1;
        }
        return ans;
    }
    public static int findL(int[] arr, int m){//ĳ���2
        // �Σ�1 1 1 1 1 1
        // ������1��ָ�붨��Σ�����Ƕ�ͷ��ָ���β��
        // ����Ƕ�β��ָ���ͷ���γ��� = abs(link[i] - i) + 1

        // link���飺ͷβ����һ���յ㣬�����Ǵ�С��
        // n + 2��_ 1 2 3 4 5 _
        int[] link = new int[arr.length + 2];

        // �γ�Ϊ m �ĸ���
        int cnt = 0;
        int res = -1;

        for (int i = 0; i < arr.length; i++) {

            int x = arr[i];
            // ��� link
            int l = link[x - 1] != 0 ? link[x - 1] : x;
            // �Ҷ� link
            int r = link[x + 1] != 0 ? link[x + 1] : x;

            // �޸� cnt
            if (x - l == m) {
                cnt--;
            }
            if (r - x == m) {
                cnt--;
            }
            if (r - l + 1 == m) {
                cnt++;
            }
            if (cnt > 0) {
                res = i + 1;
            }

            // �ϲ���
            link[l] = r;
            link[r] = l;
        }
        return res;
    }

    public static void main(String[] args) {
        findLatestStep1(new int[]{3,5,1,2,4},1);
    }
}
