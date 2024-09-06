package dp;

import java.util.Arrays;

public class Solution416 {


    public static void main(String[] args) {
        System.out.println(new Solution416().canPartition(new int[]{1, 5, 11, 5}));
    }

    /**
     * dp[j] = max(dp[j], dp[j-nums[i] + nums[i]])
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int[] dp = new int[sum / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum/2; j - nums[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[sum / 2] == sum / 2;
    }
}
