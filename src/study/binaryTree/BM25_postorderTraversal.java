package study.binaryTree;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * BM24 二叉树的后序遍历
 */
public class BM25_postorderTraversal {

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
        int[] ints = new BM25_postorderTraversal().postorderTraversal(treeNode);
        for(int a:ints){
            System.out.print((char)a+" ");
        }
    }


    public int[] postorderTraversal(TreeNode treeNode){
        List<Integer> nodeList=new ArrayList<>();
        if(treeNode==null) return null;
        afterSelectTreeNode(treeNode,nodeList);
        int nodeArr[]=new int[nodeList.size()];
        for(int i=0;i<nodeList.size();i++){
            nodeArr[i]=nodeList.get(i);
        }
        return nodeArr;
    }

    public void afterSelectTreeNode(TreeNode treeNode,List<Integer> nodeList){
        if(treeNode==null) return;
        afterSelectTreeNode(treeNode.left,nodeList);
        afterSelectTreeNode(treeNode.right,nodeList);
        nodeList.add(treeNode.val);
    }



}
