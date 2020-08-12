package lcfor2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Offer6 {
    public int[] reversePrint(ListNode head) {
        List<Integer> l=new ArrayList<>();
        while (head!=null){
            l.add(head.val);
            head=head.next;
        }
        Collections.reverse(l);
        return ListToArray(l);
    }
    public static int[] ListToArray(List<Integer> L){
        int[] a=new int[L.size()];
        for (int i=0;i<L.size();++i){
            a[i]=L.get(i);
        }
        return a;
    }
}
