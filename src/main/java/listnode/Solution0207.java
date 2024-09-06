package listnode;

public class Solution0207 {

    /**
     * 链表相交
     * <p>
     * 如果两链表相交，则一定有一个相同的尾节点
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode list = Solution0207.createList(new int[]{4, 1, 8, 4, 5});
        ListNode list1 = Solution0207.createList(new int[]{5, 0, 1, 8, 4, 5});
        ListNode intersectionNode = new Solution0207().getIntersectionNode(list, list1);
        System.out.println(intersectionNode);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 遍历两个节点，计算两个节点分别的长度
        int listALength = 0, listBLength = 0;
        ListNode pointerA = headA, pointerB = headB;
        while (pointerA != null) {
            listALength++;
            pointerA = pointerA.next;
        }
        while (pointerB != null) {
            listBLength++;
            pointerB = pointerB.next;
        }

        // 判断两链表可能在第几个节点相交
        // 两链表长度之差
        int sub = Math.abs(listALength - listBLength);

        // 使两个链表遍历到可能相交的节点，如果是同一个节点，则相交，否则不相交
        // 较长的链表先遍历sub个节点
        pointerA = headA;
        pointerB = headB;
        if (listALength > listBLength) {
            for (int i = 0; i < sub; i++) {
                pointerA = pointerA.next;
            }
        } else {
            for (int i = 0; i < sub; i++) {
                pointerB = pointerB.next;
            }
        }
        // 两链表同时开始遍历，直至找到相同的节点，或者遍历结束
        ListNode pointerRes = null;
        while (pointerA!=null){
            if (pointerA == pointerB){
                pointerRes = pointerA;
                break;
            }
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }

        return pointerRes;
    }

    public static ListNode createList(int[] nodes) {
        ListNode listNode = new ListNode();
        ListNode pointer = listNode;
        for (Integer integer : nodes) {
            ListNode node = new ListNode();
            node.val = integer;
            pointer.next = node;
            pointer = pointer.next;
        }
        return listNode.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}


