package com.algorithm.leetcode_100days;

public class Solution026 {

    /**
     * 删除有序数组中的重复项
     * @param args
     */
    public static void main(String[] args) {
        Solution026 solution026 = new Solution026();
        int i = solution026.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        System.out.println(i);
    }


    /**
     * 使用变量记载删除元素的数量delNum
     * 将每个元素移动到delNum之前的位置上
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int delNum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]){
                delNum++;
            }
            nums[i-delNum] = nums[i];
        }
        return nums.length - delNum;
    }
}
