package listnode;

public class Solution024 {

    /**
     * 两两交换链表中的节点
     * <p>
     * tips：要想交换两个节点，就必须知道这两个节点之前的一个节点；然后分别改变三个节点next
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode list = Solution203.createList();
        ListNode listNode = new Solution024().swapPairs(list);
        System.out.println(listNode);
    }

    public ListNode swapPairs(ListNode head) {
        // 保证链表最少有两个节点
        if (head == null || head.next == null) {
            return head;
        }

        ListNode headNew = new ListNode();
        headNew.next = head;
        ListNode pointer = headNew;
        while (pointer != null && pointer.next != null && pointer.next.next != null) {
            ListNode pointerLeft = pointer.next;
            ListNode pointerRight = pointer.next.next;
            pointer.next = pointerRight;
            pointerLeft.next = pointerRight.next;
            pointerRight.next = pointerLeft;
            pointer = pointer.next.next;
        }
        return headNew.next;
    }
}
