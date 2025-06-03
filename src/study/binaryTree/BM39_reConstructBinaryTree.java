package study.binaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BM40 重建二叉树
 * 通过前序遍历，确定根节点，再通过中序遍历，确定左右节点
 * 依次递归，构建二叉树
 */
public class BM39_reConstructBinaryTree {

    public static void main(String[] args) {

    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param preOrder int整型一维数组
     * @param vinOrder int整型一维数组
     * @return TreeNode类
     * 输入：
     * 前序 [1,2,4,7,3,5,6,8]
     * 中序 [4,7,2,1,5,3,8,6]
     * 复制
     * 返回值：
     * {1,2,3,4,#,5,6,#,7,#,#,8}
     */
    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        if(preOrder==null || preOrder.length==0) return null;
        TreeNode treeNode=new TreeNode(preOrder[0]);
        for(int i=0;i<vinOrder.length;i++){
            if(preOrder[0]==vinOrder[i]){
                //对winOrder进行拆分出左子树和右子树
                treeNode.left=reConstructBinaryTree(Arrays.copyOfRange(preOrder,1,1+i),Arrays.copyOfRange(vinOrder,0,i));
                treeNode.right=reConstructBinaryTree(Arrays.copyOfRange(preOrder,1+i,preOrder.length),Arrays.copyOfRange(vinOrder,i+1,vinOrder.length));
                break;
            }
        }
        return treeNode;
    }



}
