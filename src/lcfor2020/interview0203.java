package lcfor2020;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class interview0203 {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
        return;
    }
}
