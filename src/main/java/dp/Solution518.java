package dp;

public class Solution518 {

    public static void main(String[] args) {
        System.out.println(new Solution518().change2(5, new int[]{1, 2, 5}));
    }

    /**
     * dp[i][j]：使用前i种硬币，凑够金额j的方法
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        // 第0种硬币，凑够金额j的初始化
        for (int i = 1; i < amount + 1; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = 1;
            }
        }
        // 第i种硬币，凑够金额0的初始化。全部初始化为1，即使用0个硬币
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < coins.length; i++) {    // 遍历硬币
            for (int i1 = 0; i1 < amount + 1; i1++) {   // 遍历背包
                if (i1 - coins[i] >= 0) {
                    dp[i][i1] = dp[i - 1][i1] + dp[i][i1 - coins[i]];
                } else {
                    dp[i][i1] = dp[i - 1][i1];
                }
            }
        }

        return dp[coins.length - 1][amount];
    }

    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            if (i % coins[0] == 0) {
                dp[i] = 1;
            }
        }

        for (int i = 1; i < coins.length; i++) {    // 遍历硬币
            // 这里原来i1=0，但是这样就需要加一个判断i1-coins[i]>=0。所以直接改成了i1=coins[i]
            // 如果是二维dp，那还需要复制上一行的值，一维dp则不存在这个问题
            for (int i1 = coins[i]; i1 < amount + 1; i1++) {   // 遍历背包
                dp[i1] = dp[i1] + dp[i1 - coins[i]];
            }
        }
        return dp[amount];
    }

}
