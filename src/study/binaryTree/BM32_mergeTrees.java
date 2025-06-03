package study.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *BM32 合并二叉树
 */
public class BM32_mergeTrees {
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
        TreeNode ints = new BM32_mergeTrees().mergeTrees(treeNode,treeNode);
        System.out.println();


    }


    public TreeNode mergeTrees(TreeNode treeNode1,TreeNode treeNode2){

        if(treeNode1==null) return treeNode2;
        if(treeNode2==null) return treeNode1;

        TreeNode treeNode=new TreeNode(treeNode1.val+treeNode2.val);
        treeNode.left=mergeTrees(treeNode1.left,treeNode2.left);
        treeNode.right=mergeTrees(treeNode1.right,treeNode2.right);

        return treeNode;
    }






}


