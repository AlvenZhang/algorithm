package com.algorithm.leetcode_100days;

public class Solution021 {


    /**
     * 合并两个有序链表
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution021 solution021 = new Solution021();
        ListNode listNode1 = solution021.array2ListNode(new int[]{-9, 3});
        ListNode listNode2 = solution021.array2ListNode(new int[]{5, 7});
        ListNode listNode = solution021.mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode.toString());
    }


    /**
     * 归并的思想
     * 同时遍历两个链表，按照大小进行排序
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null || list2 == null) {
            if (list1 == null) {
                return list2;
            } else {
                return list1;
            }
        }

        // 确定头节点
        ListNode res = null;
        if (list1.val <= list2.val) {
            res = list1;
            list1 = list1.next;
        } else {
            res = list2;
            list2 = list2.next;
        }
        // 结果链表指针
        ListNode pointer = res;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pointer.next = list1;
                pointer = pointer.next;
                list1 = list1.next;
            } else {
                pointer.next = list2;
                pointer = pointer.next;
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            pointer.next = list1;
            pointer = pointer.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            pointer.next = list2;
            pointer = pointer.next;
            list2 = list2.next;
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


