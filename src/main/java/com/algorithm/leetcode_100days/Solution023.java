package com.algorithm.leetcode_100days;

import java.awt.*;
import java.util.*;

public class Solution023 {


    /**
     * 合并k个升序链表
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution023 solution023 = new Solution023();
        ListNode listNode1 = solution023.array2ListNode(new int[]{1});
        ListNode listNode2 = solution023.array2ListNode(new int[]{0});
        ListNode listNode3 = solution023.array2ListNode(new int[]{2, 6});
        ListNode[] listNodes = new ListNode[]{listNode1, listNode2, listNode3};
        ListNode listNode = solution023.mergeKLists2(listNodes);
        System.out.println(listNode);
    }

    /**
     * 同时遍历k个链表
     * <p>
     * 速度很慢，击败百分之五
     * 主要是寻找n个链表节点中最小值耗时较长
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 不为空的索引
        Set<Integer> index = new HashSet<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                index.add(i);
            }
        }
        if (index.isEmpty()) {
            return null;
        } else if (index.size() == 1) {
            return lists[index.iterator().next()];
        }
        // 确认头节点
        ListNode res = null;
        int in = this.min(lists, index);
        res = lists[in];
        lists[in] = lists[in].next;
        if (lists[in] == null) {
            index.remove(in);
        }
        ListNode pointer = res;

        // 遍历
        while (!index.isEmpty()) {
            in = this.min(lists, index);
            if (in == -1)
                System.out.println("123");
            pointer.next = lists[in];
            pointer = pointer.next;
            lists[in] = lists[in].next;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    index.remove(i);
                }
            }
        }

        return res;
    }

    /**
     * 使用PriorityQueue解决寻找最小值复杂度的问题
     * PriorityQueue使用堆结构实现
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {

        ListNode res = new ListNode();
        ListNode head = res;
        Comparator<ListNode> cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
//                return Integer.compare(o1.val, o2.val);
            }
        };
        PriorityQueue<ListNode> queue = new PriorityQueue<>(cmp);
        // 将最小值入队
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            res.next = poll;
            res = res.next;

            if (poll.next != null) {
                queue.add(poll.next);
            }
        }
        return head.next;
    }

    /**
     * 返回链表头节点最小值的索引
     *
     * @param listNodes
     * @return
     */
    private int min(ListNode[] listNodes, Set<Integer> index) {
        int min_index = -1;
        int min_val = Integer.MAX_VALUE;
        for (Integer i : index) {
            if (listNodes[i].val < min_val) {
                min_val = listNodes[i].val;
                min_index = i;
            }
        }
        return min_index;
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
