package study2.step1_linkList;


public class ListNode {
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

