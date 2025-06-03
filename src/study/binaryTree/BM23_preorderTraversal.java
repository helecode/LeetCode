package study.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BM23_preorderTraversal {

    public static void main(String[] args) {

    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * @param root TreeNode类
     * @return int整型一维数组
     * 使用递归的方式进行遍历，先遍历左子树，再遍历右子树
     *
     */
    public int[] preorderTraversal (TreeNode root) {
        // 定义一个List存在遍历元素
        List<Integer> nodeList=new ArrayList<>();
        this.preorderTreeNode(root,nodeList);
        int nodeArr[]=new int[nodeList.size()];
        for (int i = 0; i < nodeList.size(); i++) {
            nodeArr[i] = nodeList.get(i);
        }
        return nodeArr;
    }
    public void preorderTreeNode(TreeNode root,List<Integer> nodeList){
        if(root==null){
            return;
        }
        //遍历当前节点，再分别遍历左子树和右子树
        nodeList.add(root.val);
        //遍历左子树
        preorderTreeNode(root.left,nodeList);
        //遍历右子树
        preorderTreeNode(root.right,nodeList);
    }
}
