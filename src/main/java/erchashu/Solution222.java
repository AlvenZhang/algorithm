package erchashu;


import jdk.nashorn.internal.ir.IfNode;

/**
 * 完全二叉树节点个数
 */
public class Solution222 {

    public static void main(String[] args) {

    }


    // 遍历二叉树实现
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        int numLeft = countNodes(root.left);
        int numRight = countNodes(root.right);
        return numLeft + numRight + 1;
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
