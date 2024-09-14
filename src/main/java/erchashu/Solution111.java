package erchashu;

import java.util.Deque;
import java.util.LinkedList;

public class Solution111 {


    /**
     * 二叉树的最小深度
     * <p>
     * 也就是层序遍历过程中，一旦碰到某个节点是叶子节点，就直接返回当前深度
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        int len = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            count--;
            if (node.left == null && node.right == null) {
                return len + 1;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (count == 0){
                count = queue.size();
                len++;
            }
        }
        return len;
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
