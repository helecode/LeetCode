package study.step1_linkList;

/**
 BM10 两个链表的第一个公共结点
 */
public class BM10_FindFirstCommonNode {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode6;
        listNode6.next = listNode7;

        listNode4.next = listNode5;



        ListNode cycleEnterNode = new BM10_FindFirstCommonNode().FindFirstCommonNode(listNode1,listNode4);
        System.out.println();
    }

    /**
     * 双指针法
     * @param pHead1
     * @return pHead1
     * 两个指针同时走
     * 第一个指针先走 第一个链表，走完第一个再走第二个
     * 第二个指针先走 第二个链表，走完第二个再走第一个
     * 两个指针走过的节点个数是相同的，如果在中间相遇，那就是公共节点
     * 如果在最后相遇，那就没有公共节点
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //第一个指针
        ListNode point1=pHead1;
        //第二个指针
        ListNode point2=pHead2;
        //在中间相遇或者都走到最后则跳出循坏，所以他们一定会相遇
        while(point1==point2){
            point1=point1==null?pHead2:point1.next;
            point2=point2==null?pHead1:point2.next;
        }
        return point1;
    }

}
