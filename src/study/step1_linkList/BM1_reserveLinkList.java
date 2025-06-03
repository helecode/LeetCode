package study.step1_linkList;

import java.util.Stack;

/**
 * BM1 反转链表
 */
public class BM1_reserveLinkList {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
//        ListNode reverseList=new Solution().ReverseList(listNode1);
        ListNode listNode11=listNode1;
        listNode11.val=2;

        System.out.println();
    }
}
 class Solution_BM1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 使用栈
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode ReverseList (ListNode head) {
        //遍历链表放入栈中
        Stack<ListNode> stack=new Stack();
        if(head==null){
            return null;
        }
        while(head!=null){
            stack.push(head);
            head=head.next;
        }
        //取出第一个作为链表头
        ListNode node=stack.pop();
        ListNode firstListNode=node;
        //遍历栈组成链表
        while (!stack.isEmpty()){
            ListNode temp=stack.pop();
            node.next=temp;
            node=temp;
        }
        //链表最后一个为null
        node.next=null;
        return firstListNode;
    }

     /**
      * 使用双链表求解
      * @param head
      * @return
      */
     public ListNode ReverseList2 (ListNode head) {
       if(head==null)return null;
       ListNode nodeNew=null;
       while (head!=null){
           //先保存访问的节点的下一个节点，保存起来
           //留着下一步访问的
           ListNode temp=head.next;
           //每次访问的原链表节点都会成为新链表的头结点，
           //其实就是把新链表挂到访问的原链表节点的
           //后面就行了
           head.next=nodeNew;
           //更新新链表
           nodeNew=head;
           //重新赋值，继续访问
           head=temp;
       }
       return nodeNew;
     }
}

class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + (next!=null?next.val:null) +
                '}';
    }
}
