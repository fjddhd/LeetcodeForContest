package lcfor2020;

public class offer58_2 {
    public String reverseLeftWords(String s, int n) {
        String s1=String.copyValueOf(s.toCharArray(),0,n);
        String s2=String.copyValueOf(s.toCharArray(),n,s.length()-n);
        StringBuilder sb=new StringBuilder();
        sb.append(s2);
        sb.append(s1);
        return sb.toString();
    }
}
