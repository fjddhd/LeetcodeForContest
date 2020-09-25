package lcfor2020.contest205;

public class c1 {
    public static void main(String[] args) {
        modifyString("??y?ra?");
    }
    public static String modifyString(String s) {
        StringBuilder sb=new StringBuilder();
        int[] indexwenhao=new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='?'){
                indexwenhao[i]=1;
                sb.append('a');
            }else {
                sb.append(s.charAt(i));
            }
        }
        if (sb.length()==1){
            return sb.toString();
        }
        if (sb.length()==2){
            while (sb.charAt(0)==sb.charAt(1)){
                if (sb.charAt(1)=='z'){
                    sb.setCharAt(1,'a');
                    continue;
                }
                sb.setCharAt(1,(char)(sb.charAt(1)+1));
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            if (indexwenhao[i]==0){
                continue;
            }
            if (i>0 && i<sb.length()-1) {
                while (sb.charAt(i)==sb.charAt(i-1) || sb.charAt(i)==sb.charAt(i+1)){
                    if (sb.charAt(i)=='z'){
                        sb.setCharAt(i,'a');
                        continue;
                    }
                    sb.setCharAt(i,(char)(sb.charAt(i)+1));
                }
            }else if (i==0){
                while (sb.charAt(i)==sb.charAt(i+1)){
                    if (sb.charAt(i)=='z'){
                        sb.setCharAt(i,'a');
                        continue;
                    }
                    sb.setCharAt(i,(char)(sb.charAt(i)+1));
                }
            }else if (i==sb.length()-1){
                while (sb.charAt(i)==sb.charAt(i-1)){
                    if (sb.charAt(i)=='z'){
                        sb.setCharAt(i,'a');
                        continue;
                    }
                    sb.setCharAt(i,(char)(sb.charAt(i)+1));
                }
            }
        }
        return sb.toString();

    }
}
