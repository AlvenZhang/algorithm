package erchashu;

import com.sun.org.apache.regexp.internal.REUtil;

import java.util.Deque;
import java.util.LinkedList;

public class Solution513 {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new int[]{1});
        int bottomLeftValue2 = new Solution513().findBottomLeftValue2(tree);
        System.out.println(bottomLeftValue2);
    }


    /**
     * 使用递归法，使用前序遍历，记录最深层最左侧的值
     * @param root
     * @return
     */
    private int Deep = -1;
    private int value = 0;
    public int findBottomLeftValue2(TreeNode root) {
        helper(root, 0);
        return value;
    }
    private void helper(TreeNode root, int deep){
        if (root == null){
            return;
        }
        if (Deep < deep){
            value = root.val;
            Deep = deep;
        }
        helper(root.left, deep+1);
        helper(root.right, deep+1);
    }

    /**
     * 找到树的左下角的值.（最底层，最左边的值）
     * <p>
     * 层序，记录每层最左边的值，直到最后一层，输出值
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int width = queue.size();
        // 记录每层最左边的节点值，直至最后记录最后一层最左侧的节点值
        int res = root.val;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            width--;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (width == 0){
                if (!queue.isEmpty()){
                    res = queue.peek().val;
                }
                width = queue.size();
            }
        }
        return res;
    }
}
