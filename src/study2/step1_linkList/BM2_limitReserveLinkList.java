package study2.step1_linkList;


/**
 * BM2链表内指定区间反转
 *
 * 1.记录翻转的上一个节点和下一个节点
 * 2.对范围内的节点进行翻转
 * 3.节点翻转，对翻转的节点进行遍历，采用头部插入的方式进行翻转
 * 链表初始节点指向翻转后的下一个节点，翻转完后的翻转的上一个节点指向翻转后的尾部节点 完成翻转
 * 如果是从头翻转，则翻转后的头节点即为链表头节点
 */
public class BM2_limitReserveLinkList {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(3);
        ListNode listNode2=new ListNode(5);
        listNode1.next=listNode2;
        ListNode reverseList2=new BM2_limitReserveLinkList().reverseBetween(listNode1,1,2);
        System.out.println();
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        if(head==null || m==n)return head;
        //记录头节点，方便返回结果
        ListNode first=new ListNode(-1);
        first.next=head;
        //记录反转开始节点
        ListNode pre=null;
        //记录反转结束节点
        ListNode end=null;
        //得到翻转的前一个节点和后一个节点
        for(int i=1;i<=n;i++){
            if(i==m-1){
                pre=head;
            }
          if(i==n){
              end=head.next;
          }
          head=head.next;
        }
        //采用头插法的方翻转链表
        head=first.next;
        for(int i=1;i<=n;i++){
            ListNode currNode=head.next;
            if(i>=m && i<=n){
              head.next=end;
              end=head;
            }
            head=currNode;
        }
       //如果不是从头翻转， 则让翻转的前一个节点指向翻转后的头节点
        if(pre!=null){
            pre.next=end;
            return first.next;
        }else{
            //即翻转后的头节点即为头节点
            return end;
        }
    }


      public static class ListNode {
       int val;
       ListNode next = null;
        public ListNode(int val) {
          this.val = val;
       }
      }

}
