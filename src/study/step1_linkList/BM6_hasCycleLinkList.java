package study.step1_linkList;

import java.util.HashSet;
import java.util.Set;

/**
 BM6 判断链表中是否有环
 */
public class BM6_hasCycleLinkList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(9);
        ListNode listNode4 = new ListNode(10);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next= listNode2;
        boolean cycle = new BM6_hasCycleLinkList().hasCycle(listNode1);
        boolean cycle2 = new BM6_hasCycleLinkList().hasCycle2(listNode1);
        System.out.println();
    }

    /**
     * 快慢指针法
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        //快指针，每次走两步
        ListNode fast=head;
        //慢指针，每次走一步
        ListNode slow=head;
        //快指针每次走两步，所以没有环的一定是慢指针先到终点
        //如果有环，快慢指针一定会相遇
        boolean cycle=false;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                cycle=true;
                break;
            }

        }
        return cycle;
    }

    /**
     * hash法
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> listNodeSet=new HashSet<>();
        boolean cycle=false;
        while (head!=null){
            if(listNodeSet.contains(head)){
                return true;
            }else{
                listNodeSet.add(head);

            }
            head=head.next;
        }
        return false;
    }
}
