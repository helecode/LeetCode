package study.step1_linkList;

/**
 BM11 链表相加(二)
 */
public class BM11_AddInList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(3);
        listNode4.next=listNode5;




        ListNode cycleEnterNode = new BM11_AddInList().addInList(listNode1,listNode4);
        System.out.println();
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *  先反转两个链表
     *  再同时遍历两个链表，进行相加，值为和对10取余，大于10则向前进一位
     *  直到两个链表为null
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
       //反转链表
        ListNode headReverse1=null;
        ListNode headReverse2=null;
        while (head1!=null){
            ListNode temp=head1.next;
            head1.next=headReverse1;
            headReverse1=head1;
            head1= temp;
        }
        while (head2!=null){
            ListNode temp=head2.next;
            head2.next=headReverse2;
            headReverse2=head2;
            head2= temp;
        }

        //遍历链表进行相加
        int overflow=0;
        //相加之后的链表
        ListNode addNodeList=null;
        while(headReverse1!=null || headReverse2!=null){
            int headReverse1Val=headReverse1==null?0:headReverse1.val;
            int headReverse2Val=headReverse2==null?0:headReverse2.val;
            int node=(headReverse1Val+headReverse2Val+overflow)%10;
            ListNode addNode=new ListNode(node);
            //使用头插法
            addNode.next=addNodeList;
            addNodeList=addNode;
            overflow=(headReverse1Val+headReverse2Val+overflow)/10;

            headReverse1=headReverse1==null?null:headReverse1.next;
            headReverse2=headReverse2==null?null:headReverse2.next;
        }
        if(overflow>0){
            ListNode addNode=new ListNode(overflow);
            //使用头插法
            addNode.next=addNodeList;
            addNodeList=addNode;
        }
        return addNodeList;
    }

}
