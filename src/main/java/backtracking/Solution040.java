package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution040 {

    /**
     * 主要是只能使用一次。如果可以使用多次的话，可以使用startIndex去重；
     * 这个题目的去重挺重要
     * 树枝去重还是树层去重的问题。如何区分取决于前一个相同数值的元素是否被使用
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution040().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(lists.toString());
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];

        backtracking(ans, new ArrayList<>(), 0, target, candidates, 0, visited);

        return ans;
    }

    void backtracking(List<List<Integer>> ans, List<Integer> ansSub, int sum, int target, int[] candidates, int startIndex, boolean[] visited) {
        // 结束条件
        if (sum == target) {
            ans.add(new ArrayList<>(ansSub));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // 去重操作，树层去重，树枝不去重
            if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i] && candidates[i] + sum <= target) {
                visited[i] = true;
                ansSub.add(candidates[i]);
                backtracking(ans, ansSub, sum + candidates[i], target, candidates, i + 1, visited);
                visited[i] = false;
                ansSub.remove((Integer) candidates[i]);
            }
        }
    }
}
