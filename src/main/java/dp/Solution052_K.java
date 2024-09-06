package dp;

import java.util.Arrays;
import java.util.Scanner;

public class Solution052_K {

    /**
     * 完全背包：同一件物品可以选择无数次
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        int[] weight = new int[N];
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            weight[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }
        Solution052_K.testCompletePack2();
    }

    //先遍历物品，再遍历背包
    private static void testCompletePack() {
        int[] weight = {1, 2, 3, 4};
        int[] value = {2, 4, 4, 5};
        int bagWeight = 5;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) { // 遍历物品
            for (int j = weight[i]; j <= bagWeight; j++) { // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int maxValue : dp) {
            System.out.println(maxValue + "   ");
        }
    }

    /**
     * 没有通过
     */
    private static void testCompletePack2() {
        int[] weight = {1, 2, 3, 4};
        int[] value = {2, 4, 4, 5};
        int bagWeight = 5;

        int[][] dp = new int[weight.length][bagWeight + 1];

        for (int i = 0; i <= bagWeight; i++) {
            if (i >= weight[0]) {
                dp[0][i] = value[0] * (i / weight[0]);
            }
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                if (j - weight[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
