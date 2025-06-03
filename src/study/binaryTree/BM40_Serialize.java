package study.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BM39 通过层序遍历实现序列化二叉树
 * 序列化，将二叉树层次遍历放入二叉树中，如果子节点为空，则用#表示，保证二叉树构建的唯一顺序
 * 反序列化,将层序遍历的二叉树使用层序遍历的思想将二叉树字符串反序列化为二叉树
 */
public class BM40_Serialize {

    public static void main(String[] args) {
        TreeNode treeNode=buildTree();
        String serialize = new BM40_Serialize().Serialize(treeNode);
        TreeNode treeNode1 = new BM40_Serialize().Deserialize(serialize);
        System.out.println("ddd");
    }
    public static TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        // left child of 2 is null
        // right child of 2 is null
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    /**
     * 层序遍历序列化二叉树
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        if(root==null) return null;
        Queue<TreeNode> queue=new LinkedList<>();
        StringBuffer treeNodeSerialize=new StringBuffer();
        queue.add(root);
        treeNodeSerialize.append(root.val);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node.left!=null){
                treeNodeSerialize.append(",").append(node.left.val);
                queue.add(node.left);
            }else{
                treeNodeSerialize.append(",").append("#");
            }
            if(node.right!=null){
                treeNodeSerialize.append(",").append(node.right.val);
                queue.add(node.right);
            }else{
                treeNodeSerialize.append(",").append("#");
            }
        }
        return treeNodeSerialize.toString();
    }

    TreeNode Deserialize(String str) {
        String nodeStrArr[]=str.split(",");
        Queue<TreeNode> treeNodeSerialQueue=new LinkedList<>();
        for(String nodeValStr:nodeStrArr){
            if(nodeValStr.equals("#")){
                treeNodeSerialQueue.add(null);
            }else{
                treeNodeSerialQueue.add(new TreeNode(Integer.parseInt(nodeValStr)));
            }
        }

        Queue<TreeNode> deserializeQueue=new LinkedList<>();

        //遍历队列，构造二叉树
        TreeNode treeNode=treeNodeSerialQueue.poll();
        deserializeQueue.add(treeNode);
        while (!deserializeQueue.isEmpty()){
            TreeNode serialNode=deserializeQueue.poll();
            if(serialNode==null) continue;;
            TreeNode treeNode1=treeNodeSerialQueue.poll();
            TreeNode treeNode2=treeNodeSerialQueue.poll();
            serialNode.left=treeNode1!=null?treeNode1:null;
            serialNode.right=treeNode2!=null?treeNode2:null;
            deserializeQueue.add(serialNode.left);
            deserializeQueue.add(serialNode.right);
        }
        return treeNode;

    }

}
