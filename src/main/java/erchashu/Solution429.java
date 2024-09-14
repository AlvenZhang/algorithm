package erchashu;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution429 {


    public static void main(String[] args) {

    }


    /**
     * 层序遍历，只是子节点入队操作变成循环
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        Node lastNode = root;
        ArrayList<Integer> resSub = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.pop();
            resSub.add(node.val);
            if (node == lastNode) {
                res.add(resSub);
                resSub = new ArrayList<>();
                if (node.children.isEmpty()) {
                    lastNode = queue.peekLast();
                } else {
                    lastNode = node.children.get(node.children.size() - 1);
                }
            }
            for (Node child : node.children) {
                queue.add(child);
            }
        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
