package erchashu;

public class Solution106 {

    public static void main(String[] args) {

        TreeNode treeNode = new Solution106().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        System.out.println(treeNode);

    }

    /**
     * 使用中序和后序，构造一棵二叉树
     * 可以使用倒序的
     *
     * TODO 切数组的想法没错，具体细节还需要修改
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 找到root节点值，在inorder中的位置
        int rootPos = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (postorder[postorder.length - 1] == inorder[i]){
                rootPos = i;
                break;
            }
        }

        // 使用中序左侧节点值分割后序
        int postPos = 0;
        for (int i = 0; i < postorder.length; i++) {
            if (postorder[i] == inorder[rootPos-1]){
                postPos = i;
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        build(root, inorder, 0, rootPos-1, postorder, 0, postPos);
        build(root, inorder, rootPos+1, inorder.length-1, postorder, postPos+1, postorder.length-1 - 1);
        return root;
    }

    private void build(TreeNode root, int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {

        // 找到root节点值，在inorder中的位置
        int rootPos = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]){
                rootPos = i;
                break;
            }
        }
        // 通过后序最后一个分割中序
        // 确定中序的分割索引
        int inPos = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (postorder[postEnd] == inorder[i]){
                inPos = i;
                break;
            }
        }

        if (inStart == inEnd){
            TreeNode treeNode = new TreeNode();
            treeNode.val = inorder[inStart];
            if (inPos < rootPos){
                root.left = treeNode;
            }else {
                root.right = treeNode;
            }
            return;
        }


        // 使用中序左侧节点值分割后序
        int postPos = 0;
        for (int i = postStart; i <= postEnd; i++) {
            if (postorder[i] == inorder[inPos-1]){
                postPos = i;
                break;
            }
        }


        TreeNode treeNode = new TreeNode();
        treeNode.val = inorder[inPos];
        if (inPos < rootPos){
            root.left = treeNode;
            build(root, inorder, inStart, inPos, postorder, postStart, postPos);
        }else {
            root.right = treeNode;
            build(root, inorder, inPos, inEnd, postorder, postPos, postEnd);
        }

    }
}
