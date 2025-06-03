package study.binaryTree;

/**
 * BM34 判断是不是二叉搜索树
 *
 * 二叉树中序遍历是有序的，然后判断后面节点是否大于前面节点
 */
public class BM34_isValidBST {

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode('2');
        treeNode.left=new TreeNode(1);
        treeNode.right=new TreeNode('3');

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    int minValue=Integer.MIN_VALUE;
    public boolean isValidBST (TreeNode root) {
       if(root==null) return true;
       //判断左叶子节点是否是有序的
        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val<=minValue){
            return false;
        }
        minValue=root.val;
        if(!isValidBST(root.right)){
            return false;
        }
        return true;
    }

}
