package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution039 {
    /**
     * 同一个数字可以被无限制选取，但还是要注意所选的组合不能重复。(使用startIndex不使用visited)
     *
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution039().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists.toString());
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        backtracking(ans, new ArrayList<Integer>(), target, candidates, 0);
        return ans;
    }

    void backtracking(List<List<Integer>> ans, List<Integer> ansSub, int target, int[] candidates, int startIndex) {
        // 结束条件
        if (target <= 0) {
            if (target == 0)
                ans.add(new ArrayList<>(ansSub));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            ansSub.add(candidates[i]);
            backtracking(ans, ansSub, target - candidates[i], candidates, i);
            ansSub.remove((Integer) candidates[i]);
        }
    }
}
