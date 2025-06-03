package study.step1_linkList;

/**
 * BM4 合并两个排序的链表
 */
public class BM4_mergeLinkList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(9);
        ListNode listNode4 = new ListNode(10);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNodea = new ListNode(2);
        ListNode listNodeb = new ListNode(7);
        ListNode listNodec = new ListNode(8);
        ListNode listNoded = new ListNode(13);
        listNodea.next = listNodeb;
        listNodeb.next = listNodec;
        listNodec.next = listNoded;

        ListNode reverseList2 = new BM4_mergeLinkList().Merge(listNode1,listNodea);
        System.out.println();
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
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
