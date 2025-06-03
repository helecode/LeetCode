package study.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * BM24 二叉树的中序遍历
 */
public class BM24_inorderTraversal {

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
        int[] ints = new BM24_inorderTraversal().preorderTraversal(treeNode);
        for(int a:ints){
            System.out.print((char)a+" ");
        }
    }

    public int[] preorderTraversal(TreeNode treeNode){
        //树为空时，返回空数组
        if(treeNode==null) return  new int[0];
        //存放遍历好的元素
        List<Integer> treeNodeList=new ArrayList<>();
        middleSelectTreeNode(treeNode,treeNodeList);
        int a[]=new int[treeNodeList.size()];
        for(int i=0;i<treeNodeList.size();i++){
            a[i]=treeNodeList.get(i);
        }
        return a;
    }

    public void middleSelectTreeNode(TreeNode treeNode,List<Integer> treeNodeList){
        //如果节点为空，则直接放回
        if(treeNode==null) return;
        //先遍历左子树
        middleSelectTreeNode(treeNode.left,treeNodeList);
        //再遍历当前节点
        treeNodeList.add(treeNode.val);
        //再遍历右子树
        middleSelectTreeNode(treeNode.right,treeNodeList);
    }




}
