package com.algorithm.leetcode_100days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution040_不会去重未完成 {


    /**
     * 组合总和2️⃣
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution040_不会去重未完成 solution040 = new Solution040_不会去重未完成();
        List<List<Integer>> lists = solution040.combinationSum2(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 27);
        System.out.println(lists.toString());
    }

    /**
     * 因为不可重复使用，所以直接使用深度优先遍历
     * <p>
     * 没有想到怎么去重
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] isUsed = new int[candidates.length];
        List<List<Integer>> dfs = DFS(0, candidates, isUsed, new ArrayList<Integer>(), 0, target);
        HashSet<List<Integer>> resSet = new HashSet<>(dfs);

        ArrayList<List<Integer>> res = new ArrayList<>(resSet);
        return res;
    }

    private List<List<Integer>> DFS(int index, int[] candidates, int[] isUsed, List<Integer> subList, int sum, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int[] isUsed_sub = isUsed.clone();
        for (int i = index; i < candidates.length; i++) {
//            if (i > 0 && candidates[i] == candidates[i - 1]) {
//                continue;
//            }
            List<Integer> subList_sub = new ArrayList<>(subList);
            if (isUsed_sub[i] == 0) {
                if (candidates[i] + sum == target) {
                    subList_sub.add(candidates[i]);
                    res.add(subList_sub);
                } else if (candidates[i] + sum < target) {
                    subList_sub.add(candidates[i]);
                    isUsed_sub[i] = 1;
                    List<List<Integer>> dfs_res = DFS(i + 1, candidates, isUsed_sub, subList_sub, sum + candidates[i], target);
                    res.addAll(dfs_res);
                }
            }
        }
        return res;
    }
}
