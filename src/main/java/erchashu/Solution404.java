package erchashu;

public class Solution404 {

    public static void main(String[] args) {

    }

    /**
     * 第一印象应该是类似前序遍历
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        // 求左叶子的值
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        // 加上左右子树中左叶子的值
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}
