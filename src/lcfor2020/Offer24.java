package lcfor2020;

public class Offer24 {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        //�ȴ��������ڵ����ڵĲ���
        ListNode next;
        ListNode next1= head.next;
        head.next=null;
        while (next1!=null){
            next=next1.next;//��ǰ�洢������ֵ
            next1.next=head;//�����ӵ�
            //�����ƶ�����ָ��
            head=next1;
            next1=next;
        }
        return head;
    }
}
