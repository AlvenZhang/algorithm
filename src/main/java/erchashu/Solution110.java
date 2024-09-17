package erchashu;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

public class Solution110 {

    public static void main(String[] args) {
        Solution110 solution110 = new Solution110();
        TreeNode tree = solution110.createTree(new int[]{3, 9, 20, -1, -1, 15, 7});
        boolean balanced = solution110.isBalanced2(tree);
        System.out.println(balanced);
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
     * 递归思路
     * 修改一下返回值，看看是否能提高运行速度
     *
     * 这样可以通过，并且运行时间超过100%。 可能是创建对象什么的消耗时间太多了
     * @param root
     * @return
     */
    public boolean isBalanced3(TreeNode root) {

        return getHeight(root)!=-1;
    }

    private int getHeight(TreeNode root) {

        if (root == null){
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1 ? -1 : Math.max(leftHeight, rightHeight)+1;
    }


    /**
     * 使用递归思路
     * 每个节点的左右子树都是平衡二叉树 并且深度差距不超过1，那么这个节点为根节点的树也是平衡二叉树
     * <p>
     * 存在的问题： 想返回boolean又想返回深度。使用pair解决了
     * <p>
     * 能通过，但是使用时间较长
     *
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Pair<Boolean, Integer> left = helper(root.left);
        Pair<Boolean, Integer> right = helper(root.right);
        return Math.abs(left.getValue() - right.getValue()) <= 1 && left.getKey() && right.getKey();
    }

    private Pair<Boolean, Integer> helper(TreeNode root) {

        if (root == null) {
            return new Pair<>(true, 0);
        }

        Pair<Boolean, Integer> left = helper(root.left);
        Pair<Boolean, Integer> right = helper(root.right);

        return new Pair<>(Math.abs(left.getValue() - right.getValue()) <= 1 && left.getKey() && right.getKey(), Math.max(left.getValue(), right.getValue()) + 1);
    }

    /**
     * 层序遍历，找到第一个叶子节点之后，如果后边一层还有非叶节点，则直接返回false
     * <p>
     * 这种方法基础判断逻辑上有问题
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int width = queue.size();
        // 记录前边层次是否已经出现叶子节点
        boolean flag = false;
        // 记录本层是否出现叶子节点
        boolean flagLevel = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            width--;
            if (node.left != null || node.right != null) {
                if (flag) {
                    return false;
                }
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.left == null || node.right == null) {
                flagLevel = true;
            }
            if (width == 0) {
                width = queue.size();
                if (flagLevel) {
                    flag = true;
                }
            }
        }
        return true;
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
