package study.step1_linkList;

/**
 BM13 判断一个链表是否为回文结构
 */
public class BM13_isPail {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(7);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;


        boolean result = new BM13_isPail().isPail(listNode1);
        System.out.println();
    }

    /**
     *  BM13 判断一个链表是否为回文结构
     *  找到链表的中间位置，分成两个个数相等的链表
     *  然后反转前面的链表，判断两个链表是否相等
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail (ListNode head) {
        // write code here
        if(head==null) return false;
        if(head.next==null) return true;

        //找到中间节点
        ListNode left=head;
        ListNode right=head.next;
        while(right!=null && right.next!=null){
            left=left.next;
            right=right.next.next;
        }
        //right为null，则代表链表长度为奇数个，中间节点被分到左侧，所以手动为右侧补一个中间节点
        if(right==null){
            right=left.next;
            left.next=null;
            ListNode mid=new ListNode(left.val);
            mid.next=right;
            right=mid;
        }else{
            right=left.next;
            left.next=null;
        }

        //反转左侧链表
        ListNode reverseLeft=null;
        while(head!=null){
            ListNode temp=head.next;
            head.next=reverseLeft;
            reverseLeft=head;
            head=temp;
        }

        //遍历两个链表，判断是否相等
        while(reverseLeft!=null || right!=null){
            if(reverseLeft.val!=right.val){
                return false;
            }
            reverseLeft=reverseLeft.next;
            right=right.next;
        }

        return true;


    }

}
