package erchashu;

import com.sun.org.apache.bcel.internal.generic.ReturnInstruction;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new int[]{1, 2, 3, -1, 5});
        Solution257 solution257 = new Solution257();
        List<String> strings = solution257.binaryTreePaths(tree);
        System.out.println(strings);
    }


    /**
     * 使用回溯。（好像这样就是回溯吧，忘了回溯具体是啥样了）
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        backTracking(res, new ArrayList<>(), root);
        return res;
    }

    private void backTracking(List<String> res, ArrayList<Integer> paths, TreeNode root) {

        paths.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(paths.get(0));
            for (int i = 1; i < paths.size(); i++) {
                stringBuilder.append("->" + paths.get(i));
            }
            res.add(stringBuilder.toString());
            return;
        }

        if (root.left != null) {
            backTracking(res, paths, root.left);
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            backTracking(res, paths, root.right);
            paths.remove(paths.size() - 1);
        }
    }
}
