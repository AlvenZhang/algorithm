package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution090 {

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution090().subsetsWithDup(new int[]{1,2,2});
        System.out.println(lists.toString());
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new LinkedList<>());
        boolean[] visited = new boolean[nums.length];
        backTracking(visited, ans, new LinkedList<>(), 0, nums);
        return ans;
    }


    private void backTracking(boolean[] visited, List<List<Integer>> ans, LinkedList<Integer> ansSub, int startIndex, int[] nums) {

        // 结束条件
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            ansSub.add(nums[i]);
            ans.add(new ArrayList<>(ansSub));
            backTracking(visited, ans, ansSub, i + 1, nums);
            ansSub.removeLast();
            visited[i] = false;
        }
    }
}
