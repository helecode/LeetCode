package study.step1_linkList;

import java.util.HashSet;
import java.util.Set;

/**
 BM6 判断链表中是否有环
 */
public class BM7_cycleEnterNodeLinkList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(9);
        ListNode listNode4 = new ListNode(10);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next= listNode2;
        ListNode cycleEnterNode = new BM7_cycleEnterNodeLinkList().cycleEnterNode(listNode1);
        System.out.println();
    }

    /**
     * 快慢指针法
     * @param head
     * @return
     */
    public ListNode cycleEnterNode(ListNode head) {
        //慢指针
        ListNode slow=head;
        //快指针
        ListNode fast=head;
        //相遇节点
        ListNode comeCross=null;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        //慢指针从头节点开始，快指针从相遇节点开始，下次相遇就是环入口节点
        slow=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return slow;
            }
        }
        return null;
    }

    /**
     * hash法
     * @param head
     * @return
     */
    public ListNode hasCycle2(ListNode head) {
        Set<ListNode> listNodeSet=new HashSet<>();
        while (head!=null){
            if(listNodeSet.contains(head)){
                return head;
            }else{
                listNodeSet.add(head);

            }
            head=head.next;
        }
            return null;
        }
}
