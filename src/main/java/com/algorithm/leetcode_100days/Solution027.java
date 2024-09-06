package com.algorithm.leetcode_100days;

public class Solution027 {


    /**
     * 移除元素
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution027 solution027 = new Solution027();
        int i = solution027.removeElement(new int[]{3, 2, 2, 3}, 3);
        System.out.println(i);
    }


    /**
     * 遍历数组，并维持前半部分不为val
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        for (; j < nums.length; j++) {
            if (nums[j]!=val){
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
