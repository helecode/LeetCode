package study.step1_linkList;

/**
 BM14 链表的奇偶重排
 */
public class BM14_oddEvenList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;


        ListNode result = new BM14_oddEvenList().oddEvenList(listNode1);
        System.out.println();
    }

    /**
     *
     * BM14 链表的奇偶重排
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList (ListNode head) {
        if(head==null || head.next==null) return head;
        //定义奇链表或链表头部
        ListNode odd=head;
        ListNode oddHead=head;

        //定义偶链表或偶链表头部
        ListNode even=head.next;
        ListNode evenHead=head.next;

        head=head.next;
        while (head.next!=null && head.next.next!=null){
            ListNode temp=head.next.next;
            odd.next=head.next;
            odd=odd.next;

            even.next=head.next.next;
            even=even.next;
            head=temp;
        }
        //处理最后一个
        if(head.next!=null && head.next.next==null){
            odd.next=head.next;
            odd=odd.next;
        }

        //将链表串起来
        odd.next=evenHead;
        even.next=null;
        return oddHead;
    }

}
