package com.algorithm.leetcode_100days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution039 {

    /**
     * 组合总和
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution039 solution039 = new Solution039();
        List<List<Integer>> lists = solution039.combinationSum(new int[]{4, 2, 8}, 8);
        System.out.println(lists.toString());
    }

    /**
     * 想到使用修改的深度优先遍历
     * 一直向前遍历，直到路径节点值的和大于等于target，然后将路径节点保存并返回
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            Integer candidate = candidates[i];
            List<Integer> sub_list = new ArrayList<>();
            sub_list.add(candidate);
            if (candidate == target) {
                res.add(sub_list);
            } else if (candidate < target) {
                List<List<Integer>> helper_res = this.helper(candidates, i, candidate, target, new ArrayList<>(sub_list));
                if (!helper_res.isEmpty()) {
                    res.addAll(helper_res);
                }
            }
        }


        return res;
    }

    /**
     * 递归执行，深度优先
     */
    private List<List<Integer>> helper(int[] candidates, int pos, int sum, int target, List<Integer> subList) {

        List<List<Integer>> res = new ArrayList<>();
        for (int i = pos; i < candidates.length; i++) {
            Integer candidate = candidates[i];
            if (sum + candidate == target) {
                subList.add(candidate);
                res.add(subList);
                break;
            } else if (sum + candidate < target) {
                List<Integer> subList_son = new ArrayList<>(subList);
                subList_son.add(candidate);

                List<List<Integer>> helper_res = helper(candidates, i, sum + candidate, target, subList_son);
                if (!helper_res.isEmpty()) {
                    res.addAll(helper_res);
                }
            }
        }

        return res;
    }
}
