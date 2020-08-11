package lcfor2020;

import java.util.ArrayList;
import java.util.List;

public class lc1436 {
    public String destCity(List<List<String>> paths) {
        int i=0;
        List<String> now=paths.get(0);
        paths.remove(0);
        String first=now.get(0);
        String last=now.get(1);
        while (paths.size()>0){
            List<String> temp=paths.get(i);
            if (temp.get(0).equals(last)){
                paths.remove(i);
                last=temp.get(1);
                i=0;
                continue;
            }
            if (temp.get(1).equals(first)){
                paths.remove(i);
                first=temp.get(0);
                i=0;
                continue;
            }
            i++;
        }
        return last;
    }
}
