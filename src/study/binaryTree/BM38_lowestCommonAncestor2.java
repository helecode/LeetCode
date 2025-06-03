package study.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BM38 在二叉树中找到两个节点的最近公共祖先
 * 如果在一个节点下面能找到这两个元素，则认为是这两个元素的公共祖先
 * 再元素的左子树和右子树分别找这两个节点
 * 如果一个在左子树一个在右子树，则当前根节点是公共祖先
 * 如果两个都在右子树或者右子树，那么先遍历到的这个节点是另一个节点的祖先
 */
public class BM38_lowestCommonAncestor2 {

    public static void main(String[] args) {


    }


    /**
     * 判断当前指定节点是否存在于当前节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public Integer lowestCommonAncestor (TreeNode root, int p, int q) {
        if(root==null) return null;
        return searchNode(root,p,1);
    }


    /**
     *  判断当前指定值是否存在于当前节点
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    public Integer searchNode(TreeNode root, int node1,int node2){
        if(root==null){
            return null;
        }
        if(root.val==node1){
            return node1;
        }
        if(root.val==node2){
            return node2;
        }
        Integer left=searchNode(root.left,node1,node2);
        Integer right=searchNode(root.right,node1,node2);
        if(left==null){
            return right;
        }
        if(right==null)
            return left;
        if(left!=null && right!=null){
            return root.val;
        }
        return null;
    }

}
