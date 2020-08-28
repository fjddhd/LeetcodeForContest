package lcfor2020;

public class interview0801 {
    public int waysToStep(int n) {
        if(n <= 2) return n;
        if (n == 3) return 4;
        int[] d = new int[3];
        int ans=0;
        /**
         * n<=3时的固定值，作为状态转移方程的初始值
         * 再尝试n为4或5时发现其结果为之前三项之和
         * 所以设置三个变量储存之前三项值并且开始循环并依此转移（或存储）前三项值
         * */
        d[0] = 1;
        d[1] = 2;
        d[2] = 4;
        for (int i = 4; i <= n; i++){
            ans = (d[2] + d[1]) % 1000000007 +d[0];//防止前两项也溢出
            ans %= 1000000007;
            d[0]=d[1];
            d[1]=d[2];
            d[2]=ans;
        }
        return ans;
    }
}
