package com.algorithm.leetcode_100days;

import java.security.PrivateKey;

public class Solution033 {


    /**
     * 搜索旋转排序数组
     * <p>
     * 题目要求时间复杂度O(logn)，需要利用有序的特性，不能完全遍历一遍
     * <p>
     * 暴力解法就是，从头到尾遍历一遍，时间复杂度为O(n)
     * 想不到别的方法
     *
     * 总得来说就一句话：如果target在有序部分则去有序部分找，否则继续二分无序部分
     * 无序部分二分之后也会变得一半有序一半无序
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution033 solution033 = new Solution033();
        int search = solution033.search(new int[]{5,1,3}, 3);
        System.out.println(search);
    }


    /**
     * 将数组从中间分成两部分，则一定会有一半是有序的，另一半是无序的。（可以通过段数组分别的首尾判断是否有序）
     * 并且容易得知是否目标值在有序的那一半。
     * 如果在有序一半则二分，否则继续二分无序无序的那一部分
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // 直接二分
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 判断有序的一半
            if (nums[left] <= nums[mid]) {
                // 左边一半是有序
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {
                // 右边一半有序
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
