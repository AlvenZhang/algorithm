package com.algorithm.leetcode_100days;

public class Solution042 {

    /**
     * 接雨水
     *
     * @param args
     */
    public static void main(String[] args) {
        int trap = new Solution042().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }


    /**
     * 根据每根柱子，向右找能组成容器的柱子，计算容积并减去两者之间的柱子体积，然后i跳到右边柱子的索引继续遍历
     * 如果找不到能组成容器，那么返回继续遍历下一根柱子
     * <p>
     * 不能使用接水量大小判断右侧边界。右侧边界有两种情况：1.大于等于左侧边界；2.小于左侧边界，但是是右侧最大值
     *
     * 速度很慢，占用空间也很大
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] == 0 || (i + 1 < height.length && height[i] <= height[i + 1])) {
                continue;
            }
            // 当前组成容器最大盛水量
//            int maxTemp = 0;
            int j = i + 2;
            // 确定右侧边界
            if (j >= height.length) {
                continue;
            }
            int maxVIndex = j;
            for (; j < height.length; j++) {
                if (height[j] >= height[i]) {
                    maxVIndex = j;
                    break;
                } else if (height[j] > height[maxVIndex]) {
                    maxVIndex = j;
                }
            }
            // 粗略计算容积
            int curr = Math.min(height[i], height[maxVIndex]) * (maxVIndex - i - 1);

            // 容积减去障碍物，得到真正容积
            for (int k = i + 1; k < maxVIndex; k++) {
                curr -= Math.min(height[k], height[maxVIndex]);
            }
//            if (curr > maxTemp) {
//                maxTemp = curr;
//                if (height[i] <= height[j]) {
//                    break;
//                }
//            }
            // 累加当前容积，并将左边界移动到右边界位置
            if (curr > 0) {
                i = maxVIndex - 1;
                res += curr;
            }
        }
        return res;
    }
}
