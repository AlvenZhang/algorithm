package erchashu;

public class Solution226 {


    /**
     * 反转二叉树
     * @param args
     */
    public static void main(String[] args) {

    }


    /**
     * 使用后序遍历的方式反转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        reverse(root);
        return root;
    }

    private void reverse(TreeNode root){
        if (root.left!=null){
            reverse(root.left);
        }
        if (root.right!=null){
            reverse(root.right);
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
