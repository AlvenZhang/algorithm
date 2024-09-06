package com.algorithm.leetcode_100days;

import java.lang.annotation.ElementType;
import java.util.*;

public class Solution015 {


    /**
     * 三数之和
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution015 solution015 = new Solution015();
        List<List<Integer>> lists = solution015.threeSum2(new int[]{0, 1, 1});
        System.out.println(lists.toString());
    }

    /**
     * 暴力求解
     * 三层遍历
     * 没有想到如何去重（排序，并且本次与上次重复则跳过）
     * 超出时间限制
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

    /**
     * 双指针法：数组的头指针尾指针分别指向有序数组的头部和尾部。
     * 如果当前和大于目标值，则尾指针向前移动；如果当前和小于目标值，则头指针向后移动
     */

    /**
     * 先确定一个数，然后转换成两数之和的问题
     * 使用双指针法，解决两数之和的问题
     *
     * 速度还是不快，不知道是不是求两数之和的时候用时间太长了
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> lists = twoSum(nums, i + 1, nums.length - 1, -nums[i]);
            if (!lists.isEmpty()) {
                for (List<Integer> list : lists) {
                    list.add(nums[i]);
                }
                res.addAll(lists);
            }
        }
        return res;
    }

    /**
     * 双指针解决两数之和
     *
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    private List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> res = new ArrayList<>();

        while (start < end) {
            if (nums[start] + nums[end] > target) {
                if (start < end - 1 && nums[end] == nums[end - 1]) {
                    while (start < end - 1 && nums[end] == nums[end - 1])
                        end--;
                } else {
                    end--;
                }
            } else if (nums[start] + nums[end] < target) {
                if (start + 1 < end && nums[start] == nums[start + 1]) {
                    while (start + 1 < end && nums[start] == nums[start + 1])
                        start++;
                } else {
                    start++;
                }
            } else {
                if (start < end - 1 && nums[end] == nums[end - 1]) {
                    while (start < end - 1 && nums[end] == nums[end - 1])
                        end--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    res.add(temp);
                    end--;
                }
            }
        }
        return res;
    }
}
