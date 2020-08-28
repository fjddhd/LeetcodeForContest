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

    /**
     * 尝试参考大佬解法
     * https://leetcode-cn.com/problems/find-latest-group-of-size-m/solution/on-de-jie-jue-fang-fa-by-time-limit/
     * 左右都是 0。此时该位置作为 新增段独立存在。
     * 仅有左边或者右边。此时该位置 会将某个旧段的长度加 1。
     * 左右都是 1。此时 该位置会将两个旧段合并成一个新段。
     * */
    public static int findLatestStep3(int[] arr, int m) {//依旧超时
        int[] asist=new int[arr.length+2];//asist[i]为长度为i的1子段的数量
        int lastM=-1;//记录m长度子段为0的最后一步
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
            }else {//两边全1
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

    public static int findLatestStep4(int[] arr, int m) {//某题解
        int n = arr.length;
        int[] c = new int[n + 1];//
        int ans = -1, cnt = 0;//cnt为长度为m的子段个数
        for (int i = 0; i < n; ++i) {
            int cur = arr[i];//cur每次循环中需要置1的位置
            c[cur] = 1;
            int l = c[cur - 1];
            if (l > 0) {//
                if (l == m) --cnt;
                c[cur] += l;
                c[cur - l] = c[cur];
            }
            if (cur + 1 <= n && c[cur + 1] > 0) {//后向
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
    public static int findL(int[] arr, int m){//某题解2
        // 段：1 1 1 1 1 1
        // 核心是1个指针定义段：如果是段头就指向段尾，
        // 如果是段尾就指向段头，段长度 = abs(link[i] - i) + 1

        // link数组：头尾各有一个空点，所以是大小是
        // n + 2：_ 1 2 3 4 5 _
        int[] link = new int[arr.length + 2];

        // 段长为 m 的个数
        int cnt = 0;
        int res = -1;

        for (int i = 0; i < arr.length; i++) {

            int x = arr[i];
            // 左段 link
            int l = link[x - 1] != 0 ? link[x - 1] : x;
            // 右段 link
            int r = link[x + 1] != 0 ? link[x + 1] : x;

            // 修改 cnt
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

            // 合并段
            link[l] = r;
            link[r] = l;
        }
        return res;
    }

    public static void main(String[] args) {
        findLatestStep1(new int[]{3,5,1,2,4},1);
    }
}
