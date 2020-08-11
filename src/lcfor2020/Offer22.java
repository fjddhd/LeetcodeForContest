package lcfor2020;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ArrayDeque<ListNode> L=new ArrayDeque<>();
        while (head!=null){
            if (L.size()>=k){
                L.poll();
            }
            L.add(head);
            head=head.next;
        }
        return L.peek();
    }
}
