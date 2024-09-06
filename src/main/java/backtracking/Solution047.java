package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution047 {

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution047().permuteUnique(new int[]{1, 2, 3});
        System.out.println(lists.toString());
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backTracking(visited, ans, new LinkedList<>(), nums);
        return ans;
    }

    private void backTracking(boolean[] visited, List<List<Integer>> ans, LinkedList<Integer> ansSub, int[] nums) {
        // 结束条件
        if (ansSub.size() == nums.length) {
            ans.add(new LinkedList<>(ansSub));
            return;
        }
        HashSet<Integer> used = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i] && !used.contains(nums[i])) {
                used.add(nums[i]);
                ansSub.add(nums[i]);
                visited[i] = true;
                backTracking(visited, ans, ansSub, nums);
                visited[i] = false;
                ansSub.removeLast();
            }
        }
    }
}
