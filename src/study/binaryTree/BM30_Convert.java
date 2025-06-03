package study.binaryTree;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BM30 二叉搜索树与双向链表
 */
public class BM30_Convert {
    TreeNode pre;
    TreeNode next;


    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode('F');
        treeNode.left=new TreeNode('D');
        treeNode.left.left=new TreeNode('B');
        treeNode.left.right=new TreeNode('E');
        treeNode.left.left.left=new TreeNode('A');
        treeNode.left.left.right=new TreeNode('C');

        treeNode.right=new TreeNode('G');
        treeNode.right.right=new TreeNode('I');
        treeNode.right.right.left=new TreeNode('H');
        treeNode.right.right.right=new TreeNode('J');
        TreeNode ints = new BM30_Convert().Convert(treeNode);
        System.out.println();


    }


    public TreeNode Convert(TreeNode treeNode){
        Queue<TreeNode> treeNodeQueue=new LinkedList<>();
        if(treeNode==null) return null;
        middleTree(treeNode,treeNodeQueue);
        //取出栈第一个最为头节点
        TreeNode pre=null;
        TreeNode curr=null;
        TreeNode head=null;
        while (!treeNodeQueue.isEmpty()){
            //当前节点为空，代表为当前节点
            TreeNode node=treeNodeQueue.poll();
            if(curr==null){
                curr=node;
                //记录链表头
                head=node;
            }else{
                pre=curr;
                curr=node;
                pre.right=curr;
                curr.left=pre;
            }
        }
        return head;
    }


    /**
     * 中序遍历链表
     * @param treeNode
     * @param treeNodeQueue
     */
    public void middleTree(TreeNode treeNode, Queue<TreeNode> treeNodeQueue){
        if(treeNode==null) return;
        middleTree(treeNode.left,treeNodeQueue);
        treeNodeQueue.add(treeNode);
        middleTree(treeNode.right,treeNodeQueue);
    }



}


