package dp;

import java.util.Arrays;

public class Solution1049 {

    public static void main(String[] args) {
        System.out.println(new Solution1049().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }


    /**
     * 可以看作两堆石头相撞，所以要做的就是将尽可能将分成两堆差不多重量的石头
     * 也就是使用m/2大小的背包，尽可能装满背包
     * 状态转移方程：dp[j] = max(dp[j], dp[j-stones[i]]+stones[i])
     *
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int num = stones.length;
        int sum = Arrays.stream(stones).sum();
        int bagSize = sum / 2;
        int[] dp = new int[bagSize + 1];

        // 如果一块石头都不放，则重量为0。所以第一行初始化为0

        for (int i = 0; i < num; i++) {
            for (int j = bagSize; j - stones[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
//        System.out.println(Arrays.toString(dp));
        return sum - dp[bagSize] * 2;
    }
}
