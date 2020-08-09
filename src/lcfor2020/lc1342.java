package lcfor2020;

public class lc1342 {
    public int numberOfSteps (int num) {
        if (num==0)
            return 0;
        String s=Integer.toBinaryString(num);
        int res=s.length();
        for (int i=0;i<s.length();++i){
            if (i!=0 && s.charAt(i)=='1'){
                res++;
            }
        }
        return res;
    }
}
