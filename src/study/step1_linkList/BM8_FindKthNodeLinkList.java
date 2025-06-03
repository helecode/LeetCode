package study.step1_linkList;

/**
 BM8 链表中倒数最后k个结点
 */
public class BM8_FindKthNodeLinkList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode cycleEnterNode = new BM8_FindKthNodeLinkList().FindKthToTail(listNode1,10);
        System.out.println();
    }

    /**
     * 双指针法
     * @param pHead
     * @return
     * 第一个指针先移动k步，然后第二个指针再从头开始
     * 这个时候这两个指针同时移动，当第一个指针到链表的末尾的时候，返回第二个指针即可
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode first=pHead;
        ListNode seconds=pHead;
        //第一指针先移动k步，然后再两个指针一起移动
        //当第二个指针移到最后时，则返回第一个指针
        int i=1;
        for(;first!=null;i++){
            first=first.next;
            if(i>k){
                seconds=seconds.next;
            }
        }
        if(i<k){
            return null;
        }
        return seconds;

    }

}
