package study2.step1_linkList;

/**
 *BM1 反转链表
 * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头
 *
 * 头部插入的方式会反转链表
 * 1.记录链表的头部节点，初始时为null
 * 2.遍历链表，将遍历的节点都指向头部节点(头部插入)
 *
 */
public class BM1_reserveLinkList {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode ReverseList (ListNode head) {
        if(head==null) return null;
        //记录链表头的节点
        ListNode preHead=null;
        //对链表进行遍历
        while(head!=null){
            //先记录下一个，防止head的next改变找不到该节点
            ListNode nextNext=head.next;
            //让下一个指向头
            head.next=preHead;
            preHead=head;
            head=nextNext;
        }
        return preHead;
    }
}
