package study.binaryTree;

/**
 *BM33 二叉树的镜像
 */
public class BM32_treesMirror {
    TreeNode pre;
    TreeNode next;


    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode('F');
        treeNode.left=new TreeNode('D');
        treeNode.left.left=new TreeNode('B');
        treeNode.left.right=new TreeNode('E');
        treeNode.left.left.left=new TreeNode('A');
        treeNode.left.left.right=new TreeNode('C');
        TreeNode ints = new BM32_treesMirror().Mirror(treeNode);
        System.out.println();


    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *即将其所有左右子树交换
     *我们可以考虑自底向上依次交换二叉树的左右节点。
     *
     * 第一次先交换最左侧的根节点，交换最左侧节点的叶子节点的
     * 然后再交换最左侧的根节点的兄弟节点，交换兄弟节点的叶子节点
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public TreeNode Mirror (TreeNode pRoot) {
        if(pRoot==null) return null;

        TreeNode left=Mirror(pRoot.left);
        TreeNode right=Mirror(pRoot.right);
        pRoot.right=left;
        pRoot.left=right;
        return pRoot;
    }






}


