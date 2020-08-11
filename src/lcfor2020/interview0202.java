package lcfor2020;

import java.util.ArrayDeque;

public class interview0202 {
    public int kthToLast(ListNode head, int k) {
        ArrayDeque<Integer> ad=new ArrayDeque<>();
        while (head!=null){
            if (ad.size()>=k) {
                ad.poll();
            }
            ad.add(head.val);
            head=head.next;
        }
        return ad.peek();
    }
}
