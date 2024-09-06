package backtracking;

import sun.reflect.annotation.AnnotationSupport;

import javax.imageio.spi.ImageTranscoderSpi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution491 {

    /**
     * 本题中只需要关注横向是否重复即可
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> subsequences = new Solution491().findSubsequences(new int[]{1, 1, 1, 1});
        System.out.println(subsequences.toString());
    }


    public List<List<Integer>> findSubsequences(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        backTracking(ans, new LinkedList<>(), 0, nums);
        return ans;
    }

    private void backTracking(List<List<Integer>> ans, LinkedList<Integer> ansSub, int startIndex, int[] nums) {

        // 结束条件
        if (startIndex >= nums.length) {
            return;
        }

        // 只需要记录本层中是否取到重复的元素
        HashSet<Integer> visited = new HashSet<>();

        for (int i = startIndex; i < nums.length; i++) {
            if (visited.contains(nums[i]) || (!ansSub.isEmpty() && nums[i] < ansSub.getLast())) {
                continue;
            }
            visited.add(nums[i]);
            ansSub.add(nums[i]);
            if (ansSub.size() >= 2) {
                ans.add(new LinkedList<>(ansSub));
            }
            backTracking(ans, ansSub, i + 1, nums);
            // 每层中的记录数组都是新的，所以不能恢复
//            visited[i] = false;
            ansSub.removeLast();
        }
    }
}
