package erchashu;

import java.util.*;

public class Solution637 {

    public static void main(String[] args) {

    }

    /**
     * 每层平均值
     *
     * 速度很慢
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode end = root;
        queue.add(root);
        double sum = 0;
        int levelSize = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            sum+=node.val;
            levelSize++;
            if (end == node){
                res.add(sum / levelSize);
                sum = 0;
                levelSize = 0;
                if (node.right!=null){
                    end = node.right;
                }else if (node.left != null){
                    end = node.left;
                }else {
                    end = queue.peekLast();
                }
            }
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
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
