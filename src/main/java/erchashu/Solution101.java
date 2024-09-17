package erchashu;

import javax.management.QueryEval;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution101 {

    public static void main(String[] args) {
        Solution101 solution101 = new Solution101();
        TreeNode tree = solution101.createTree(new int[]{1, 2, 2, 3, 4, 4, 3});
        boolean symmetric = solution101.isSymmetric2(tree);
        System.out.println(symmetric);
    }

    public TreeNode createTree(int[] nums) {
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

    /**
     * 比较两棵树的对称性
     *
     * @param root
     * @return
     */
    public boolean isSymmetric3(TreeNode root) {
        return compare(root.left, root.right);
    }

    // 比较两棵树是否对称
    // 同时对两棵树进行遍历
    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left != null && right != null && left.val != right.val) {
            return false;
        }

        // 比较外侧
        boolean outside = compare(left.left, right.right);
        // 比较内侧
        boolean inside = compare(left.right, right.left);
        return outside && inside;
    }

    /**
     * 层序遍历补null，判断每层遍历结果是否对称
     * 第一步层序遍历记录层数
     * 第二步层序遍历判断是否对称（补null）
     * <p>
     * 过了过了，但是只超过了0.66%
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 第一次遍历
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int len = 0;
        int width = queue.size();
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            width--;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (width == 0) {
                width = queue.size();
                len++;
            }
        }
        // 第二次层序遍历
        queue.add(root);
        width = queue.size();
        ArrayList<Integer> cache = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (node == null) {
                cache.add(null);
                queue.add(null);
                queue.add(null);
            } else {
                cache.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            width--;
            if (width == 0) {
                // 判断cache是否对称
                for (int i = 0; i < cache.size(); i++) {
                    Integer i1 = cache.get(i);
                    Integer i2 = cache.get(cache.size() - i - 1);
                    if (i1 == null || i2 == null) {
                        if (i1 != i2) {
                            return false;
                        }
                    } else if (!i1.equals(i2)) {
                        return false;
                    }
                }
                cache = new ArrayList<>();
                width = queue.size();
                len--;
                if (len == 0) {
                    return true;
                }
            }
        }
        return true;
    }


    /**
     * 判断是否二叉树轴对称
     * <p>
     * 中序遍历，如果中序遍历结果对称，则是轴对称
     * <p>
     * 想法不对，有些空的树枝需要补null，这个方法也解决不了这个问题
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayList res = new ArrayList<>();
        helper(root, res);
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) != res.get(res.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void helper(TreeNode root, List res) {
        if (root == null) {
            res.add(null);
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
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
