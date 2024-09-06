package dp;

public class Solution746 {

    public static void main(String[] args) {
        System.out.println(new Solution746().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    /**
     * 使用dp记录到达每个台阶所要花费的总费用
     * 第n个台阶的最低花费为dp[n] = min(dp[n-1],dp[n-2]) + cost[n]
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
