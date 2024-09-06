package com.algorithm.leetcode_100days;

public class Solution024 {


    /**
     * 两两交换链表中的节点
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution024 solution024 = new Solution024();
        ListNode listNode1 = solution024.array2ListNode(new int[]{1, 2, 3, 4});
        ListNode listNode = solution024.swapPairs(listNode1);
        System.out.println(listNode);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        ListNode res = head.next;
        ListNode temp_pointer = head.next;
        head.next = temp_pointer.next;
        temp_pointer.next = head;

        while (head.next != null && head.next.next != null) {
            temp_pointer = head.next;
            head.next = temp_pointer.next;
            temp_pointer.next = temp_pointer.next.next;
            head.next.next = temp_pointer;

            head = head.next.next;
        }
        return res;
    }

    private ListNode array2ListNode(int[] array) {
        if (array.length == 0)
            return null;
        ListNode listNode = new ListNode(array[0], null);
        ListNode pointer = listNode;

        for (int i = 1; i < array.length; i++) {
            pointer.next = new ListNode(array[i], null);
            pointer = pointer.next;
        }

        return listNode;
    }
}
