package com.algorithm.leetcode_100days;

import javax.swing.plaf.SliderUI;

public class Solution041 {


    /**
     * 缺失的第一个正整数
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution041 solution041 = new Solution041();
        int i = solution041.firstMissingPositive(new int[]{1});
        System.out.println(i);
    }


    /**
     * 记得之前考研做过，但是已经忘了，直接看题解
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            // 将其与num-1位置的值互换
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
