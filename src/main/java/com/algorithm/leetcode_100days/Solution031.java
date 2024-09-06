package com.algorithm.leetcode_100days;

import java.util.Arrays;

public class Solution031 {


    /**
     * 下一个排列
     *
     * 写出来了，但是不知道为什么快
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution031 solution031 = new Solution031();
        int[] array = new int[]{1, 2, 5, 3, 2, 1};
        solution031.nextPermutation3(array);
        System.out.println(Arrays.toString(array));
    }


    /**
     * 1. 从右向左遍历，找到nums[i] > nums[i+1]，将两者互换
     * 2. 将[i, s.length)升序排序
     * <p>
     * 思路错误
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        for (; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
                break;
            }
        }
        // 升序排序
        for (int j = i; j < nums.length - 1; j++) {
            for (int k = nums.length - 1; k > j; k--) {
                if (nums[k] < nums[k - 1]) {
                    int temp = nums[k];
                    nums[k] = nums[k - 1];
                    nums[k - 1] = temp;
                }
            }
        }
    }

    /**
     * 1. 从右向左遍历，找到nums[i] > nums[i+1]，将两者互换
     * 2. 从[i,nums.length)中，找到num[k]>nums[i] && nums[k]<nums[i+1]，将nums[k]与nums[i]互换
     * 3. 将[i+1,nums.length)升序排序
     *
     * @param nums
     */
    public void nextPermutation2(int[] nums) {
        int i = nums.length - 1;
        for (; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int min = i;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1] && nums[j] < nums[min]) {
                        min = j;
                    }
                }
                int temp = nums[i - 1];
                nums[i - 1] = nums[min];
                nums[min] = temp;
                break;
            }
        }

        // 升序排序
        for (int j = i; j < nums.length; j++) {
            for (int k = nums.length - 1; k > j; k--) {
                if (nums[k] < nums[k - 1]) {
                    int temp = nums[k];
                    nums[k] = nums[k - 1];
                    nums[k - 1] = temp;
                }
            }
        }
    }

    /**
     * 官方解法
     * @param nums
     */
    public void nextPermutation3(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
