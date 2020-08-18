package lcfor2020;

public class Offer24 {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        //先处理两个节点以内的操作
        ListNode next;
        ListNode next1= head.next;
        head.next=null;
        while (next1!=null){
            next=next1.next;//提前存储第三个值
            next1.next=head;//反连接点
            //依次移动两个指针
            head=next1;
            next1=next;
        }
        return head;
    }
}
