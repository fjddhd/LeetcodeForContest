package lcfor2020;

public class interview0801 {
    public int waysToStep(int n) {
        if(n <= 2) return n;
        if (n == 3) return 4;
        int[] d = new int[3];
        int ans=0;
        /**
         * n<=3ʱ�Ĺ̶�ֵ����Ϊ״̬ת�Ʒ��̵ĳ�ʼֵ
         * �ٳ���nΪ4��5ʱ��������Ϊ֮ǰ����֮��
         * ��������������������֮ǰ����ֵ���ҿ�ʼѭ��������ת�ƣ���洢��ǰ����ֵ
         * */
        d[0] = 1;
        d[1] = 2;
        d[2] = 4;
        for (int i = 4; i <= n; i++){
            ans = (d[2] + d[1]) % 1000000007 +d[0];//��ֹǰ����Ҳ���
            ans %= 1000000007;
            d[0]=d[1];
            d[1]=d[2];
            d[2]=ans;
        }
        return ans;
    }
}
