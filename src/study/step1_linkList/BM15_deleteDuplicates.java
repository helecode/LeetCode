package study.step1_linkList;

/**
 BM15 删除有序链表中重复的元素-I
 */
public class BM15_deleteDuplicates {
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


        ListNode result = new BM15_deleteDuplicates().deleteDuplicates(listNode1);
        System.out.println();
    }

    /**
     *
     * BM15 删除有序链表中重复的元素-I
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *  判断后面的值是否与当前值是否相等，如果相等，这将当前值指向后面的后一个值，当前值不变
     *  直到后一个值与当前不相等时才向后移动一位
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode headNode=head;
        while (head!=null && head.next!=null){
            if(head.val==head.next.val){
                head.next=head.next.next;
            }else{
                head=head.next;
            }
        }
        return headNode;
    }

}
