package study.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BM36 判断是不是平衡二叉树
 * 平衡二叉树的左叶子节点和右叶子节点的深度不超过1
 *
 */
public class BM36_iIsBalanced {

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode('2');
        treeNode.left=new TreeNode(1);
        treeNode.right=new TreeNode('3');
        new BM36_iIsBalanced().IsBalanced_Solution(treeNode);

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return bool布尔型
     */

    public boolean IsBalanced_Solution (TreeNode root) {
        if(root==null) return true;
        int leftDeep=getTreeDeep(root.left);
        int rightDeep=getTreeDeep(root.right);
        if(leftDeep-rightDeep>1 || leftDeep-rightDeep<-1) return false;
        return true;
    }

    /**
     * 得到树的深度
     * @param treeNode
     * @return
     */
    public int getTreeDeep(TreeNode treeNode){
        if(treeNode==null) return 0;
        return Math.max(getTreeDeep(treeNode.left),getTreeDeep(treeNode.right))+1;
    }

}
