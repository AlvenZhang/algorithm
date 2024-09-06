package listnode;



import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class Solution203 {

    public static void main(String[] args) {
        ListNode list = Solution203.createList();
        ListNode listNode = new Solution203().removeElements(list, 7);
    }

    /**
     * 答案
     */
    public ListNode removeElements2(ListNode head, int val) {
        // 设置一个虚拟的头结点
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    /**
     * 这种做法蠢死了
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode headNode = new ListNode();
        headNode.next = head;
        ListNode pointer1 = headNode;
        ListNode pointer2 = headNode.next;
        while (pointer1 != null) {
            if (pointer2 != null && pointer2.val == val) {
                pointer1.next = pointer2.next;
            } else {
                pointer1 = pointer1.next;
            }
            if (pointer2 != null) {
                pointer2 = pointer2.next;
            }
        }
        return headNode.next;
    }

    public static ListNode createList() {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        ListNode listNode = new ListNode();
        ListNode pointer = listNode;
        pointer.val = scanner.nextInt();
        for (int i = 0; i < num - 1; i++) {
            pointer.next = new ListNode();
            pointer = pointer.next;
            pointer.val = scanner.nextInt();
        }
        scanner.close();
        return listNode;
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

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}