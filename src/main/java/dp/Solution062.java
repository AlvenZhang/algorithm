package dp;

public class Solution062 {


    public static void main(String[] args) {
        System.out.println(new Solution062().uniquePaths(3, 7));
    }


    /**
     * dp记录到达每个方格的不同路径数量。
     * 到达每个方格只能从左侧或者上侧的方格移动过来，所以dp[i][j] = dp[i-1][j] + dp[i][j-1]
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
