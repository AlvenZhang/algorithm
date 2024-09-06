package com.algorithm.leetcode_100days;

import java.util.List;

public class Solution019 {


    /**
     * 删除链表的倒数第N个节点
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution019 solution019 = new Solution019();
        ListNode listNode1 = solution019.array2ListNode(new int[]{1,2});
        ListNode listNode = solution019.removeNthFromEnd(listNode1, 2);
        System.out.println(listNode.toString());
    }

    /**
     * 1. 遍历一遍链表得到链表的长度
     * 2. 第二次遍历链表，删除相应结点
     *
     * 也可以使用双下标法，近似一遍扫描。（两个下标之间间隔n，快的下标扫描到链表尾部，慢的下标刚好指向要删除的节点）
     * 但实际上两个下标加起来的移动次数并没有减少
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null){
            return null;
        }
        ListNode pointer = head;
        int length = 0;
        // 确定ListNode的长度
        while (pointer != null) {
            pointer = pointer.next;
            length++;
        }
        if (length<=n){
            return head.next;
        }
        // 确定删除位置
        int position = length - n;
        pointer = head;
        while (true){
            position--;
            if (position == 0){
                pointer.next = pointer.next.next;
                break;
            }
            pointer = pointer.next;
        }
        return head;
    }

    private ListNode array2ListNode(int[] array) {
        ListNode listNode = new ListNode(array[0], null);
        ListNode pointer = listNode;

        for (int i = 1; i < array.length; i++) {
            pointer.next = new ListNode(array[i], null);
            pointer = pointer.next;
        }

        return listNode;
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
