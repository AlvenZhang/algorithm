package com.algorithm.leetcode_100days;

import java.util.Arrays;

public class Solution016 {


    /**
     * 最接近的三数之和
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution016 solution016 = new Solution016();
        int i = solution016.threeSumClosest(new int[]{-1,2,1,-4}, 1);
        System.out.println(i);
    }

    /**
     * 类似三数之和
     * 先用一个数减去target，然后找两个数接近剩余值
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {

        // 递增排序
        Arrays.sort(nums);

        // 与target之间的差值
        int gap = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int remainV = target - nums[i];    // 剩余值

            // 双指针找最接近的值
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail){
                int sum = nums[head] + nums[tail];
                if (Math.abs(remainV - sum) < gap){
                    gap = Math.abs(remainV - sum);
                    res = sum + nums[i];
                }

                if (remainV > sum){
                    // 和过小，左端点移动
                    head++;
                }else if (remainV < sum){
                    // 和过大，右端点移动
                    tail--;
                }else {
                    // 等于，直接返回值
                    return target;
                }
            }
        }
        return res;
    }
}
