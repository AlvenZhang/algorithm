package com.algorithm.leetcode_100days;

public class Solution011 {


    /**
     * 盛最多水的容器
     * @param args
     */
    public static void main(String[] args) {
        Solution011 solution011 = new Solution011();
        int i = solution011.maxArea2(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(i);
    }


    /**
     * 暴力求解
     * 遍历每种组合
     * 超出时间限制
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxV = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int tempV = (j - i) * Math.min(height[i], height[j]);
                if (maxV < tempV){
                    maxV = tempV;
                }
            }
        }
        return maxV;
    }

    /**
     * maxArea的值取决于两个值 j-i 和 min(height[i],height[j])
     * 可以首先让j-i取得最大值，也就是分别处于height的两侧
     * 然后变动 min(height[i],height[j])
     *      如果移动height[i],height[j]中较大的一个，那么maxArea只会变小或者不变
     *      移动height[i],height[j]中较小的一个，maxArea有可能变大
     *    所以不断移动两者中较小的那个，直到i=j
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int maxV = 0;

        while (i != j){
            int tempV = (j - i) * Math.min(height[i],height[j]);
            if (maxV < tempV){
                maxV = tempV;
            }
            if (height[i] < height[j]){
                int tempHeight = height[i];
                while (i < j && tempHeight >= height[i]){
                    i++;
                }
            }else {
                int tempHeight = height[j];
                while (i < j && tempHeight >= height[j]){
                    j--;
                }
            }
        }

        return maxV;
    }
}
