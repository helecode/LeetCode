package study.binaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BM41 输出二叉树的右视图
 * 通过层次遍历实现，遍历记录每层的节点数，然后判断是否是该层最后的一个节点，是的话则添加到结果中
 */
public class BM41_treeRightView {

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 5, 3};
        int[] vinOrder = {4, 2, 5, 1, 3};
        new BM41_treeRightView().solve(preOrder,vinOrder);
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
                //不在第一个才有左子树
                treeNode.left=reConstructBinaryTree(Arrays.copyOfRange(preOrder,1,1+i),Arrays.copyOfRange(vinOrder,0,i));
                //不在最后一个才有右子树
                treeNode.right=reConstructBinaryTree(Arrays.copyOfRange(preOrder,1+i,preOrder.length),Arrays.copyOfRange(vinOrder,i+1,vinOrder.length));

                break;
            }
        }
        return treeNode;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 求二叉树的右视图
     * @param preOrder int整型一维数组 先序遍历
     * @param vinOrder int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve (int[] preOrder, int[] vinOrder) {
        TreeNode treeNode = reConstructBinaryTree(preOrder, vinOrder);
        //存储层次遍历的元素
        Queue<TreeNode> elect=new LinkedList<>();
        //存储最右视图的结果
        Queue<Integer> res=new LinkedList<>();
        elect.add(treeNode);
        while (!elect.isEmpty()){
            int count=elect.size();
            for(int i=1;i<=count;i++){
                TreeNode node=elect.poll();
                if(i==count){
                    res.add(node.val);
                }
                if(node.left!=null){
                    elect.add(node.left);
                }
                if(node.right!=null){
                    elect.add(node.right);
                }
            }
        }

        int resArr[]=new int[res.size()];
        for(int i=0;!res.isEmpty();i++){
            resArr[i]=res.poll();
        }
        return resArr;
    }



}
