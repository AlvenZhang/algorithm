package com.algorithm.leetcode_100days;

public class Solution025_未完成 {


    /**
     * K个一组反转链表
     * @param args
     */
    public static void main(String[] args) {
        Solution025_未完成 solution025 = new Solution025_未完成();
        ListNode listNode1 = solution025.array2ListNode(new int[]{1, 2, 3, 4, 5});
        ListNode listNode = solution025.reverseKGroup(listNode1, 2);
        System.out.println(listNode);
    }


    /**
     * 按K分组，然后将分组内的链表翻转
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode tail = head;

        for (int i = 1; i < k; i++) {
            tail = tail.next;
            if (tail == null){
                // 不足k，返回原链表
                return pre.next;
            }
        }
        // 反转分组内的节点
        head = this.myReverse(pre, head, tail);
        pre.next = tail;
        tail = head;

        while (true){
            for (int i = 1; i < k; i++) {
                tail = tail.next;
                if (tail == null){
                    // 不足k，返回原链表
                    return pre.next;
                }
            }
            // 反转分组内的节点
            head = this.myReverse(pre, head, tail);
            tail = head;
        }

//        return pre.next;
    }


    private ListNode myReverse(ListNode pre, ListNode head, ListNode tail){
        ListNode curr = head.next;
        ListNode next = curr.next;
        ListNode firstNode = head;
        while (head != tail){
            curr.next = head;
//            head.next = next;
            pre.next = curr;
//            pre = pre.next;
            head = curr;
            curr = next;
            next = next.next;
        }
        firstNode.next = curr;
        return curr;
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
