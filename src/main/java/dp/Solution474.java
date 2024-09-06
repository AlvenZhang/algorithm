package dp;

public class Solution474 {


    public static void main(String[] args) {
        System.out.println(new Solution474().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    /**
     * dp数组的含义：dp[i][j]，最大背dp[i][j]物品，i个0，j个1。最终要求的是dp[m][n]
     * 递推公式：dp[i][j] = max(dp[i-x][j-y]+1,dp[i][j])
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        // 遍历字符
        for (String str : strs) {
            // 统计字符串的1/0字符数量
            int x = 0;
            int y = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    x++;
                } else {
                    y++;
                }
            }
            // 背包
            for (int i = m; i >= x; i--) {
                for (int j = n; j >= y; j--) {
                    dp[i][j] = Math.max(dp[i - x][j - y] + 1, dp[i][j]);
                }
            }
        }

        return dp[m][n];
    }
}
