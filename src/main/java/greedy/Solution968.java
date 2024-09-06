package greedy;

public class Solution968 {

    public static void main(String[] args) {
        System.out.println(new Solution968().minCameraCover(null));
    }

    public int minCameraCover(TreeNode root) {
        return 1;
    }
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
