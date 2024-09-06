package com.algorithm.leetcode_100days;

import com.sun.org.apache.bcel.internal.generic.FALOAD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution047 {
    /**
     * 组成全排列的方法只想到了 多次循环
     * 感觉难点在于如何避免 重复问题
     *
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution047().permuteUnique(new int[]{3, 3, 0, 3});
        System.out.println(lists.toString());
    }

    /**
     * 不会去重
     * <p>
     * 避免重复的策略：
     * * 对nums进行排序；
     * * 若对某个数值的元素只使用一次，则确保使用该数值的第一个元素
     * * 若对某个数值的元素使用多次，确保第一个一定被首先使用
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 确定nums的长度
        int numsOfLen = nums.length;

        // 排序
        Arrays.sort(nums);

        // 定义标志是否访问过的数组
        int[] visited = new int[numsOfLen];

        ArrayList<List<Integer>> lists = new ArrayList<>();

        // 定义返回列表
        backTrack(nums, visited, lists, 0, new ArrayList<Integer>());


        return lists;
    }

    private void backTrack(int[] nums, int[] visited, List<List<Integer>> ans, int idx, List<Integer> ans_sub) {

        if (idx == nums.length) {
            ans.add(new ArrayList<>(ans_sub));
        }
        // 尚有元素未被访问
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                // 确保上一个元素已被使用
                if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                    continue;
                }
                // 将当前元素表示为已使用
                visited[i] = 1;
                // 使用当前元素
                ans_sub.add(nums[i]);
                // 选取下一个元素
                backTrack(nums, visited, ans, idx + 1, ans_sub);
                // 将当前元素复原
                visited[i] = 0;
                ans_sub.remove(idx);
            }
        }
    }
}
