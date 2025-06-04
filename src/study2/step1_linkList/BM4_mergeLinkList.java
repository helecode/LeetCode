package study2.step1_linkList;

import org.w3c.dom.NodeList;

/**
 * BM4 合并两个排序的链表
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 同时遍历两个链表的表头节点
 * 将较小的表头插入到新链表的尾部
 * 当其中一个链表为空时，则将另一条链表中的剩余节点直接加入到链表的尾部
 *
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
        if(pHead1==null)return pHead2;
        else if(pHead2==null) return pHead1;
        ListNode pre=new ListNode(-1);
        //记录头节点，用于存储结果
        ListNode head=pre;
        while (pHead1!=null && pHead2!=null){
            //比较两个节点，将较小的节点插入到新链表中
            if(pHead1!=null && pHead1.val<pHead2.val){
                pre.next=pHead1;
                pre=pHead1;
                pHead1=pHead1.next;
            }else if(pHead2.val<=pHead1.val) {
                pre.next=pHead2;
                pre=pHead2;
                pHead2=pHead2.next;
            }
        }
        //当其中一个链表为空时，则将另一条链表中的剩余节点直接加入到链表的尾部
        if(pHead2==null){
            pre.next=pHead1;
        }
        else if(pHead1==null){
            pre.next=pHead2;
        }
        return head.next;
    }

}


