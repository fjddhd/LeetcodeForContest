package lcfor2020;
/**
 *�����һ���ǿ��ַ�Ϊ�����߸���ʱ���򽫸÷�����֮���澡���ܶ�����������ַ�����������γ�һ���з���������
 * �����һ���ǿ��ַ������֣���ֱ�ӽ�����֮�������������ַ�����������γ�һ��������
 * ���ַ�������Ч����������֮��Ҳ���ܻ���ڶ�����ַ�����ô��Щ�ַ����Ա����ԣ����ǶԺ�����Ӧ�����Ӱ�졣
 *
 * ע�⣺������ַ����еĵ�һ���ǿո��ַ�����һ����Ч�����ַ���
 * �ַ���Ϊ�ջ��ַ����������հ��ַ�ʱ������ĺ�������Ҫ����ת�������޷�������Чת����
 * */
public class lc8 {
    public static int myAtoi(String str) {
        int sign=1;
        char[] chars = str.toCharArray();
        StringBuilder sb=new StringBuilder();
        boolean findFirst=false;
        boolean isGetSign=false;//��ʼ�ǿո���������������Ҳ����0
        boolean findFirstNonZero=false;
        for (int i = 0; i <chars.length; i++) {
            if (!findFirstNonZero && isGetSign && (chars[i]=='-' || chars[i]=='+')){//ע��&& �� || ���ȼ�����һ��
                return 0;
            }
            if (!findFirst){
                if (chars[i]<'0' || chars[i]>'9'){
                    if (chars[i]==' '){
                        continue;
                    }else if (chars[i]=='-' || chars[i]=='+'){
                        sb.append(chars[i]);
                        findFirst=true;
                        isGetSign=true;
                    }else {
                        return 0;
                    }
                }else {
                    if (chars[i]!='0') {
                        findFirstNonZero=true;
                        sb.append(chars[i]);
                    }
                    findFirst=true;
                }
            }else {
                if (chars[i]<'0' || chars[i]>'9'){
//                    if (chars[i]=='.'){
//                        break;
//                    }
                    break;
                }else {
                    if (chars[i]!='0'){
                        findFirstNonZero=true;
                    }else {
                        if (!findFirstNonZero){
                            continue;
                        }
                    }
                    sb.append(chars[i]);
                }
            }
        }
        if (sb.length()==0){
            return 0;
        }
        if (sb.charAt(0)=='-'){
            sign=-1;
            sb.delete(0,1);
        }else if (sb.charAt(0)=='+'){
            sb.delete(0,1);
        }
        if (sb.length()==0){
            return 0;
        }
        if (sb.length()>=11){
            if (sign==-1){
                return Integer.MIN_VALUE;
            }else {
                return Integer.MAX_VALUE;
            }
        }
        long ans2=0;
        for (int i = 0; i < sb.length(); i++) {
            ans2=ans2*10+(int)(sb.charAt(i)-'0');
        }
        if (ans2>Integer.MAX_VALUE){
            if (sign==-1 && -ans2<=Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
        return (int)ans2*sign;
    }

    public static void main(String[] args) {
        myAtoi("  0000000000012300000");
    }
}
