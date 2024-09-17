package erchashu;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
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

    public static TreeNode createTree(int[] nums) {
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode rootNode = new TreeNode(nums[0]);
        queue.add(rootNode);
        int cur = 1;
        while (cur < nums.length) {
            TreeNode node = queue.pop();
            if (nums[cur] != -1) {
                TreeNode treeNode = new TreeNode(nums[cur]);
                node.left = treeNode;
                queue.add(treeNode);
            }
            cur++;
            if (nums[cur] != -1) {
                TreeNode treeNode = new TreeNode(nums[cur]);
                node.right = treeNode;
                queue.add(treeNode);
            }
            cur++;
        }

        return rootNode;
    }
}
