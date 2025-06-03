package study.step1_linkList;

/**
 * BM2链表内指定区间反转
 */
public class BM2_limitReserveLinkList {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;

        ListNode reverseList2=new BM2_limitReserveLinkList().reverseBetween(listNode1,2,4);
        System.out.println();
    }
    public ListNode reverseBetween (ListNode head, int m, int n) {
        //添加空头指向链表用于记录链表开始位置
        ListNode first=new ListNode(-1);
        first.next=head;

        //记录反转开始的前一个位置和反转开始位置
        ListNode pre=null;
        ListNode cur=null;
        for(int i=1;i<m;i++){
            pre=head;
            cur=head.next;
        }

        //反转链表
        //只有一个节点是不用反转，所以每次反转都是反转当前节点的后一个节点后pre的后面，也就是反转链表的开头
        for(int i=m;i<n;i++){
            ListNode temp=cur.next;
            cur.next=temp.next;
            temp.next=pre.next;
            pre.next=temp;
        }
        return first.next;
    }
}
