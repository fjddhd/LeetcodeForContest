package lcfor2020;
/**
 *如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、
 * 字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * */
public class lc8 {
    public static int myAtoi(String str) {
        int sign=1;
        char[] chars = str.toCharArray();
        StringBuilder sb=new StringBuilder();
        boolean findFirst=false;
        boolean isGetSign=false;//起始非空格连续任意正负号也返回0
        boolean findFirstNonZero=false;
        for (int i = 0; i <chars.length; i++) {
            if (!findFirstNonZero && isGetSign && (chars[i]=='-' || chars[i]=='+')){//注意&& 和 || 优先级可能一致
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
