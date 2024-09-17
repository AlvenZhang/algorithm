package erchashu;

public class Solution112 {


    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new int[]{5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, 1});
        Solution112 solution112 = new Solution112();
        boolean b = solution112.hasPathSum(tree, 22);
        System.out.println(b);
    }

    /**
     * 路径总和
     * <p>
     * 找到一个根节点到叶子节点的路径，路径上所有节点值相加等于目标和
     * <p>
     * 考虑使用前序遍历
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                return true;
            }
        }

        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);

        return left || right;
    }

}
