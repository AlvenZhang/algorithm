package erchashu;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution199 {

    public static void main(String[] args) {

    }

    /**
     * 层序遍历，只记录每层最右侧的节点值
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode end = root;
        while (!queue.isEmpty()){
            TreeNode node = queue.pop();
            if (end == node){
                res.add(end.val);
                if (node.right!=null) {
                    end = node.right;
                }else if (node.left!=null){
                    end = node.left;
                }else {
                    end = queue.peekLast();
                }
            }

            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
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
