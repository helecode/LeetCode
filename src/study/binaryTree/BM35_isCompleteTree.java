package study.binaryTree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BM35 判断是不是完全二叉树
 *
 * 二叉树通过链表进行层序遍历，当遍历到两个为null的节点时，则不是完全二叉树
 */
public class BM35_isCompleteTree {

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode('2');
        treeNode.left=new TreeNode(1);
        treeNode.right=new TreeNode('3');
        new BM35_isCompleteTree().isCompleteTree(treeNode);

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return bool布尔型
     */

    public boolean isCompleteTree (TreeNode root) {
        if(root==null) return true;
        //节点为空标识
        boolean flag=false;
        //声明队列
        Queue<TreeNode> treeNodeQueue=new LinkedList<>();
        treeNodeQueue.add(root);
        while(!treeNodeQueue.isEmpty()){
            TreeNode currNode=treeNodeQueue.poll();
            if(currNode==null){
                flag=true;
                continue;
            }
            if(!flag){
                return false;
            }

            treeNodeQueue.add(currNode.left);
            treeNodeQueue.add(currNode.right);
        }
        return true;
    }

}
