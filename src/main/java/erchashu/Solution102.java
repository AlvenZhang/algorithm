package erchashu;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.regexp.internal.REUtil;

import javax.swing.tree.TreeNode;
import javax.xml.stream.events.EndElement;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution102 {


    public static void main(String[] args) {
        // -1表示null
        TreeNode tree = new Solution102().createTree(new int[]{3, 9, 20, -1, -1, 15, 7});
        List<List<Integer>> lists = new Solution102().levelOrder(tree);
        System.out.println(lists.toString());

    }

    // 根据数组，层序创建二叉树
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
     * 使用队列进行 **层序遍历**
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 指向每层的最后一个节点
        TreeNode end = root;
        ArrayList<Integer> resSub = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            resSub.add(node.val);
            // 处理层数
            if (end == node) {
                res.add(resSub);
                resSub = new ArrayList<>();
                if (node.right != null) {
                    end = node.right;
                } else if (node.left != null) {
                    end = node.left;
                } else {
                    // 本层最后一个节点没有子节点，end指向queue中最后一个node（也就是刚入队的那一个）
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
