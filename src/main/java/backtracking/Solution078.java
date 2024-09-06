package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution078 {

    /**
     * 组合问题和分割问题是收集树的叶子节点；子集问题是找树的所有节点
     *
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> subsets = new Solution078().subsets(new int[]{1, 2, 3});
        System.out.println(subsets.toString());
    }

    public List<List<Integer>> subsets(int[] nums) {

        ArrayList<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        backTracking(ans, new LinkedList<>(), 0, nums);
        return ans;
    }

    private void backTracking(List<List<Integer>> ans, LinkedList<Integer> ansSub, int startIndex, int[] nums) {

        // 结束条件
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            ansSub.add(nums[i]);
            ans.add(new ArrayList<>(ansSub));
            backTracking(ans, ansSub, i+1, nums);
            ansSub.removeLast();
        }
    }
}
