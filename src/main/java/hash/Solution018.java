package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution018 {


    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution018().fourSum(new int[]{-5,-4,-3,-2,-1,0,0,1,2,3,4,5}, 0);
        System.out.println(lists.toString());
    }

    /**
     * 沿着上一个题的惯性思路，使用双指针，先确定两个数，然后双指针确定另外两个
     * <p>
     * 但是时间复杂度是n^3
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3 ; i++) {
            if (nums[i] > 0 && nums[i] > target){
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int i1 = i + 1; i1 < nums.length - 2; i1++) {
                if (nums[i] + nums[i1] > 0 && nums[i] + nums[i1] > target){ // 这个剪枝操作出现问题，提前退出了
                    return res;
                }
                if (i1 > i + 1 && nums[i1] == nums[i1 - 1]) {
                    continue;
                }
                // 双指针确定另外两个值
                int left = i1 + 1, right = nums.length - 1;
                while (left != right) {
                    if (left > i1 + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    } else if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }
                    long sum = (long) nums[i] + (long) nums[i1] + (long) nums[left] + (long) nums[right];
                    if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[i1]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);
                        left++;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
