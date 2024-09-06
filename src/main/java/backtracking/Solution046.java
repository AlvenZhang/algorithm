package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution046 {
    public static void main(String[] args) {
        List<List<Integer>> permute = new Solution046().permute(new int[]{1, 2, 3});
        System.out.println(permute.toString());
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        ArrayList<List<Integer>> ans = new ArrayList<>();
        backTracking(visited, ans, new LinkedList<>(), nums);
        return ans;
    }

    private void backTracking(boolean[] visited, List<List<Integer>> ans, LinkedList<Integer> ansSub, int[] nums) {
        // 结束条件
        if (ansSub.size() == nums.length) {
            ans.add(new LinkedList<>(ansSub));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ansSub.add(nums[i]);
                backTracking(visited, ans, ansSub, nums);
                visited[i] = false;
                ansSub.removeLast();
            }
        }
    }
}
