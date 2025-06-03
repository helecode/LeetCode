package study.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BM37 二叉搜索树的最近公共祖先
 * 对需要比较的节点进行搜索，搜索所走过的路径放在队列中
 * 然后判断两个元素对应路径队列的值
 *
 */
public class BM37_lowestCommonAncestor {

    public static void main(String[] args) {


    }


    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public Integer lowestCommonAncestor (TreeNode root, int p, int q) {
        if(root==null) return null;
        Queue<Integer> treePathP = getTreePath(root, p);
        Queue<Integer> treePathQ = getTreePath(root, q);
        Integer commonNode=null;
        for(int i=0;i<treePathP.size()&&i<treePathQ.size();i++){
            Integer pval=treePathP.poll();
            Integer qval=treePathQ.poll();
            if(pval==qval) {
                commonNode=pval;
                continue;
            } else{
                return commonNode;
            }
        }
        return commonNode;
    }


    /**
     * 得到指定节点的路径
     * @param root
     * @param nodeVal
     * @return
     */
    public Queue<Integer> getTreePath(TreeNode root, int nodeVal){
        Queue<Integer> nodePath=new LinkedList<>();
        if(root!=null && root.val!=nodeVal){
            nodePath.add(root.val);
            if(root.val>nodeVal){
                root=root.left;
            }else{
                root=root.right;
            }
        }
        return nodePath;

    }

}
