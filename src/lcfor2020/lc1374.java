package lcfor2020;

public class lc1374 {
    public String generateTheString(int n) {
        if (n==1)
            return "a";
        if (n==2)
            return "ab";
        StringBuilder sb=new StringBuilder();
        if (n%2==1){
            for (int i=0;i<n;++i){
                sb.append("a");
            }

        }else {
            for (int i=0;i<n-1;++i){
                sb.append("a");
            }
            sb.append("b");
        }
        return sb.toString();

    }
}
