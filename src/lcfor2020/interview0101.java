package lcfor2020;

public class interview0101 {
    public boolean isUnique(String astr) {
        for (int i=0;i<astr.length();++i){
            for (int j=0;j<astr.length();++j){
                if (i==j){
                    continue;
                }
                if (astr.charAt(i)==astr.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}

