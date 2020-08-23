package lcfor2020.contest203;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class c1 {//5495
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> L=new ArrayList<>();
        int i=rounds[0];
        while (i!=rounds[rounds.length-1]){
            L.add(i);
            i++;
            i=i%(n);
            if (i==0){
                i=n;
            }
        }
        L.add(i);
        Collections.sort(L);
        return L;
    }
}
