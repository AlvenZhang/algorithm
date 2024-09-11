package erchashu;

import java.util.*;

public class Solution107 {

    public static void main(String[] args) {

    }


    /**
     * 层序遍历，然后逆转顺序
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode end = root;
        ArrayList<Integer> resSub = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            resSub.add(node.val);
            if (node == end) {
                res.add(resSub);
                resSub = new ArrayList<>();
                if (node.right != null) {
                    end = node.right;
                } else if (node.left != null) {
                    end = node.left;
                } else {
                    end = queue.peekLast();
                }
            }

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        Collections.reverse(res);
        return res;
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
