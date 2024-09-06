package com.algorithm.leetcode_100days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution046 {


    // 全排列
    public static void main(String[] args) {
        List<List<Integer>> permute = new Solution046().permute2(new int[]{0, 1});

        System.out.println(permute.toString());
    }

    /**
     * 第一反应想到递归
     *
     * 第一次改进：去掉重复克隆的visited
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {

        int[] visited = new int[nums.length];
        return this.helper(nums, visited);
    }

    private List<List<Integer>> helper(int[] nums, int[] visited) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            // 表示没有访问
            if (visited[i] == 0) {
                visited[i] = 1;
                List<List<Integer>> cache = helper(nums, visited);
                // 撤销标记
                visited[i] = 0;
                if (cache == null) {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    res.add(integers);
                }else {
                    int finalI = i;
                    cache.forEach(f -> f.add(nums[finalI]));
                    res.addAll(cache);
                }
            }
        }
        return res.isEmpty() ? null : res;
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}
