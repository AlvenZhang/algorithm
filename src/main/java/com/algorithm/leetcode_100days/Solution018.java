package com.algorithm.leetcode_100days;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution018 {

    /**
     * 四数之和
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution018 solution018 = new Solution018();
        List<List<Integer>> lists = solution018.fourSum(new int[]{0, 0, 0, -1000000000, -1000000000, -1000000000, -1000000000}, -1000000000);
        System.out.println(lists.toString());
    }


    /**
     * 两层循环选择两个数
     * 双指针法选择另外两个数
     * 时间复杂度O(n^3)
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        // 排序
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }

        long temp_sum_1 = (long) nums[0] + nums[1] + nums[2] + nums[3];
        if (temp_sum_1 > target) {
            return res;
        }

        // 剩余值大小
        long remainV = 0;

        // 两层循环指定两个数
        for (int i = 0; i < nums.length; i++) {
            while (i - 1 >= 0 && i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            if (i == nums.length) {
                break;
            }
            // 优化
            long temp_sum = (long) nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
            if (temp_sum < target) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                while (j - 1 >= i + 1 && j < nums.length && nums[j] == nums[j - 1]) {
                    j++;
                }
                if (j == nums.length) {
                    break;
                }
                remainV = (long) target - nums[i] - nums[j];

                // 双指针选择剩余两个数
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    while (left - 1 >= j + 1 && left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right + 1 <= nums.length - 1 && left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                    if (left == right) {
                        break;
                    }

                    long sum = nums[left] + nums[right];
                    if (remainV > sum) {
                        left++;
                    } else if (remainV < sum) {
                        right--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
