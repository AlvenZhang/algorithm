package erchashu;

import java.util.Deque;
import java.util.LinkedList;


/**
 * 116&117都用这个代码提交通过了
 */
public class Solution116 {


    public static void main(String[] args) {
        Solution116 solution116 = new Solution116();
        Node tree = solution116.createTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        Node connect = solution116.connect(tree);
        System.out.println(connect);
    }


    /**
     * 层序创建二叉树
     */
    private Node createTree(int[] nodes){
        Node root = new Node(nodes[0]);
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()){
            Node node = queue.pop();
            node.left = new Node(nodes[i++]);
            node.right = new Node(nodes[i++]);
            if (i >= nodes.length){
                return root;
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        return root;
    }

    /**
     * 填充每个节点的下一个右侧节点指针
     * <p>
     * 层序遍历，记录前一个节点，每层最后一个节点指向Nnull
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        // 记录每个层次节点数量
        Integer count = 1;
        while (!queue.isEmpty()) {
            Node node = queue.pop();
            count--;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (count == 0) {
                count = queue.size();
                node.next = null;
                continue;
            }
            node.next = queue.peek();
        }
        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
