package lcfor2020;

public class interview1607 {
    /**
     * ��ʽmax��a��b��=(abs(a-b)+a+b)/2
     * */
    /**
     * // �ȿ���û�����ʱ����������� b - a �����λ��������Ŀ������ʾ k = 1 ʱ a > b���� b - a Ϊ��
     *         int k = b - a >>> 31;
     *         // �ٿ��� a b ��ŵ��������ʱ����ѡ�����ŵ�����
     *         int aSign = a >>> 31, bSign = b >>> 31;
     *         // diff = 0 ʱͬ�ţ�diff = 1 ʱ���
     *         int diff = aSign ^ bSign;
     *         // ����ţ��� diff = 1 ʱ��ʹ֮ǰ����� k ��Ч��ֻ�����������ֵ�������ϵ
     *         k = k & (diff ^ 1) | bSign & diff;
     *         return a * k + b * (k ^ 1);
     *
     * ���ߣ�1ujin
     * ���ӣ�https://leetcode-cn.com/problems/maximum-lcci/solution/chun-wei-yun-suan-bu-yong-longzhuan-huan-bu-yong-n/
     * ��Դ�����ۣ�LeetCode��
     * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     * */
    public int maximum(int a, int b) {
        long aa=a;
        long bb=b;
        return (int) ((Math.abs(aa-bb)+aa+bb)/2);
    }
}
