package dp;

public class Solution377 {

    public static void main(String[] args) {
        System.out.println(new Solution377().combinationSum4_test(new int[]{1, 2, 3}, 4));
    }

    public int combinationSum4(int[] nums, int target) {

        int[][] dp = new int[nums.length][target + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < target + 1; i++) {
            if (i % nums[0] == 0) {
                dp[0][i] = 1;
            }
        }

        for (int j = 1; j < target + 1; j++) {  // 遍历背包
            for (int i = 1; i < nums.length; i++) { // 遍历数字
                if (j - nums[i] >= 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j - nums[i]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }

        }
        return dp[nums.length - 1][target];
    }

    public int combinationSum4_test(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
