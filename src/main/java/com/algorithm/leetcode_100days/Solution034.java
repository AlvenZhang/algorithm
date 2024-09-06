package com.algorithm.leetcode_100days;

import java.util.Arrays;

public class Solution034 {

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     * <p>
     * 看到logn，就想到使用二分去解决
     * <p>
     * 首先想到使用二分，分别找到小于等于target-1和大于等于target+1的两个值。随后就能确定
     *
     *
     * 经验：
     * 1. 二分查找边界条件不容易确定，可以将三种条件（大于小于等于）都分别列出来，然后写清楚每种条件的操作
     * 2. 如果出现left = mid；不做任何处理的话，会出现无限循环。这时候需要将取mid操作变为 **上取整**
     * @param args
     */
    public static void main(String[] args) {
        Solution034 solution034 = new Solution034();
        int[] ints = solution034.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(ints));
    }


    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = subL(nums, target);
        if (left == -1) {
            return new int[]{-1, -1};
        }
        int right = subR(nums, target);

        return new int[]{left, right};
    }

    // 使用二分查找左边界
    private int subL(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid;
            } else {
                // nums[mid] > target
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    // 使用二分查找左边界
    private int subR(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 代码中含有left = mid，需要将取中间数的行为变为上取整
            int mid = (left + right + 1) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid;
            } else {
                // nums[mid] > target
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
