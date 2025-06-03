package study.step1_linkList;

/**
 BM12 单链表的排序
 */
public class BM12_sortInList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(7);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;


        ListNode cycleEnterNode = new BM12_sortInList().sortInList(listNode1);
        System.out.println();
    }

    /**
     * BM12 单链表的排序
     *将链表分别分别两条链表进行合并排序
     *排序之前分别将两条链表进行分裂，进行合并排序
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *

     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList (ListNode head) {
        if(head==null) {return null;}
        if(head.next==null) {return head;}
        //分裂链表
        ListNode left=head;
        ListNode right=head.next;
        while (right!=null && right.next!=null){
            left=left.next;
            right=right.next.next;
        }
        right=left.next;
        left.next=null;
        //拆分为两个链表，将两个链表进行再次拆分，直到拆到只剩一个
        return Merge(sortInList(head),sortInList(right));
    }

    /**
     * 合并两个有序链表
     * @param pHead1 ListNode类
     * @param pHead2 ListNode类
     * @return ListNode类
     */
    public ListNode Merge(ListNode pHead1, ListNode pHead2) {
        // 找出合并链表头部
        ListNode head=null;
        if(pHead1.val<pHead2.val){
            head=pHead1;
            pHead1=pHead1.next;
        }else{
            head=pHead2;
            pHead2=pHead2.next;
        }
        //记录已经合并的链表节点
        ListNode cur=head;

        while (pHead1!=null && pHead2!=null){
            //取出两个链表数值较小的头部节点，拼接到新链表
            if(pHead1.val<pHead2.val){
                cur.next=pHead1;
                pHead1=pHead1.next;
            }else{
                cur.next=pHead2;
                pHead2=pHead2.next;
            }
            cur= cur.next;
        }
        cur.next=pHead1==null?pHead2:pHead1;
        return head;
    }

}
