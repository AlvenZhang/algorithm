package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution216().combinationSum3(3, 9);
        System.out.println(lists.toString());
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        boolean[] visited = new boolean[10];
        ArrayList<List<Integer>> ans = new ArrayList<>();
        backtracking(visited, 1, ans, new ArrayList<>(), k, n);
        return ans;
    }

    void backtracking(boolean[] visited, int startIndex, List<List<Integer>> ans, List<Integer> ansSub, int k, int remind) {
        // 剪枝操作
        if (remind < 0){
            return;
        }
        // 结束条件
        if (k == 0) {
            if (remind == 0) {
                ans.add(new ArrayList<>(ansSub));
            }
            return;
        }

        // 遍历
        for (int i = startIndex; i <= 9 - k + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ansSub.add(i);
                backtracking(visited, i + 1, ans, ansSub, k - 1, remind - i);
                visited[i] = false;
                ansSub.remove((Integer) i);
            }
        }
    }
}
