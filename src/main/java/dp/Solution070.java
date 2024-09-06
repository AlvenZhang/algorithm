package dp;

public class Solution070 {


    public static void main(String[] args) {
        System.out.println(new Solution070().climbStairs(3));
    }

    /**
     * dp[n] = dp[n-1]+dp[n-2]
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }


        return dp[dp.length - 1];
    }
}
