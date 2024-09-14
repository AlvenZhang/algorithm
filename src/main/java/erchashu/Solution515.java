package erchashu;

import com.sun.org.apache.bcel.internal.generic.POP;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution515 {


    /**
     * 层序遍历，使用数字记录层数（也就是记录每层有多少个节点，）
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 记录每个层次节点数量
        Integer count = 1;
        // 记录层数
//        Integer numLayer = 0;
        Integer cache = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            cache = Math.max(cache, node.val);
            count--;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (count == 0){
                count = queue.size();
                res.add(cache);
                cache = Integer.MIN_VALUE;
            }
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
