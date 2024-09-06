package dp;

import java.util.Arrays;


public class Solution046_K {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        testWeightBagProblem2(weight, value, bagSize);
    }


    /**
     * 二维dp数组
     * dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i])
     * dp[i-1][j]：未放物品i时，背包的最大价值。（容量j，前i-1物品随便放时，最大价值）
     * dp[i-1][j-weight[i]]+value[i]：放置物品i时，背包的最大价值。
     * dp[i-1][j-weight[i]]：未放物品i，但需要留出放置物品i的空间时，背包最大价值。（容量j-weight[i]，前i-1物品随便放时，最大价值）
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int num = value.length;
        int[][] dp = new int[num][bagSize + 1];

        // 初始化dp
        for (int i = weight[0]; i <= bagSize; i++) {
            dp[0][i] = value[0];
        }
        for (int i = 0; i < num; i++) {
            dp[i][0] = 0;
        }

        // 更新dp数组
        for (int i = 1; i < num; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        // 打印dp数组
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

    }

    /**
     * 一维dp数组
     * dp[j] = max(dp[j], dp[j-weight[i]]+value[i])
     * 假设等式前边的dp[j]是容量为j任意放前i个物品，则等号后边的dp[j]是指容量为j任意放前i-1个物品
     * dp[j-weight[i]]是容量为j-weight[i]任意放前i-1个物品最大价值
     * j是指容量，i是通过循环隐藏起来了。遍历j的时候需要从后往前遍历，因为更新dp[j]（指i时）需要dp[x]（x<j，此时的dp[x]是指i-1时）
     *
     * @param weight
     * @param value
     * @param bagSize
     */
    public static void testWeightBagProblem2(int[] weight, int[] value, int bagSize) {

        int[] dp = new int[bagSize + 1];

        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= 0; j--) {
                if (j >= weight[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
//                else{
//                    dp[j] = dp[j];
//                }
            }
        }
        // 打印dp数组
        System.out.println(Arrays.toString(dp));

    }


}
