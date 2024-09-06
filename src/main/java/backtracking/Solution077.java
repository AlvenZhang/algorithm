package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution077 {

    /**
     * 注意组合问题不能有重复
     *
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> combine = new Solution077().combine(4, 2);
        System.out.println(combine.toString());
    }

    public List<List<Integer>> combine(int n, int k) {
        boolean[] visited = new boolean[n + 1];
        ArrayList<List<Integer>> ans = new ArrayList<>();
        backtracking(1, visited, ans, new ArrayList<Integer>(), n, k);
        return ans;
    }

    /**
     * @param startIndex 控制搜索的起始位置
     * @param visited
     * @param ans
     * @param ansSub
     * @param n
     * @param k
     */
    void backtracking(int startIndex, boolean[] visited, List<List<Integer>> ans, List<Integer> ansSub, int n, int k) {
        // 终止条件
        // 遍历到指定深度（整数个数）之后结束遍历
        if (k == 0) {
            ans.add(new ArrayList<>(ansSub));
            return;
        }

        // 遍历
        // 添加剪枝i <= n - k + 1，后边元素不够就不再继续遍历
        for (int i = startIndex; i <= n - k + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ansSub.add(i);
                backtracking(i + 1, visited, ans, ansSub, n, k - 1);
                // 恢复状态
                visited[i] = false;
                ansSub.remove((Integer) i);
            }
        }
    }
}
