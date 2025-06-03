package study.step1_linkList;

/**
 BM16 删除有序链表中重复的元素-II
 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 1-1-1-2-3
 2-3
 */
public class BM16_deleteDuplicates2 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;


        ListNode result = new BM16_deleteDuplicates2().deleteDuplicates(listNode1);
        System.out.println();
    }

    /**
     *
     * BM15 删除有序链表中重复的元素-I
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 不能用当前来判断相等，因为相等一个都不保留
     * 判断当前节点的第一个和第二个值是否相等，相等的话则从第一个值开始判断
     * 判断第一个是否相等，相等则跳到后一个，判断第二个是否相等，如果相等，则继续跳到后一个，判断第三个是否相等
     * 如果不与前面的值相等则跳出，而且正好把中间相等的数据给跳过了
     * @param head ListNode类
     * @return ListNode类
     */

    public ListNode deleteDuplicates (ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode headNode=new ListNode(0);
        ListNode headTemp=headNode;
        headNode.next=head;
        head=headNode;
        while (head.next!=null && head.next.next!=null){
            if(head.next.val==head.next.next.val){
                int value=head.next.val;
                while (head.next.val==value){
                    head.next=head.next.next;
                }
            }else {
                head=head.next;
            }
        }
        return  headTemp;
    }

}
