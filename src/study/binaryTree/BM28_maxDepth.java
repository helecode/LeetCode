package study.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * BM28 二叉树的最大深度
 */
public class BM28_maxDepth {

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
        int ints = new BM28_maxDepth().maxDepth(treeNode);

    }


    public int maxDepth(TreeNode treeNode){
        if(treeNode==null)return 0;
        int treeNodeLeftDepth=maxDepth(treeNode.left)+1;
        int treeNodeRightDepth=maxDepth(treeNode.right )+1;
        int treeDepth=Math.max(treeNodeLeftDepth,treeNodeRightDepth);
        return treeDepth;
    }




}
