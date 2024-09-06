package dp;

public class Solution063 {


    public static void main(String[] args) {
        System.out.println(new Solution063().uniquePathsWithObstacles(new int[][]{{0}}));
    }

    /**
     * 同样背包问题
     * 将障碍物位置设置为特殊数值，一旦碰到则不考虑这条路径
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m == 1 && n == 1) {
            return 1;
        }
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1 || dp[0][i - 1] == Integer.MAX_VALUE) {
                dp[0][i] = Integer.MAX_VALUE;
                continue;
            }
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1 || dp[i - 1][0] == Integer.MAX_VALUE) {
                dp[i][0] = Integer.MAX_VALUE;
                continue;
            }
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else {
                    if (dp[i - 1][j] != Integer.MAX_VALUE && dp[i][j - 1] != Integer.MAX_VALUE) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    } else if (dp[i - 1][j] == Integer.MAX_VALUE && dp[i][j - 1] == Integer.MAX_VALUE) {
                        dp[i][j] = Integer.MAX_VALUE;
                    } else if (dp[i - 1][j] != Integer.MAX_VALUE) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (dp[i][j - 1] != Integer.MAX_VALUE) {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }

        return dp[m - 1][n - 1] == Integer.MAX_VALUE ? 0 : dp[m - 1][n - 1];
    }
}
