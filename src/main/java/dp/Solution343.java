package dp;

public class Solution343 {

    public static void main(String[] args) {
        System.out.println(new Solution343().integerBreak(10));
    }

    /**
     * 要想乘积最大，就尽可能将其拆成相同的数
     * dp[2]=1*1=1、dp[3]=1*2=2、dp[4]=2*2=4、dp[5]=2*dp[3]=6、dp[6]=3*3=9、dp[7]=3*4=12、dp[8]=4*4=16、dp[9]=max(3*6,3*dp[6])=27
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                int cache = Math.max(j * (i - j), j * dp[i - j]);
                if (cache > dp[i]) {
                    dp[i] = cache;
                }
            }
        }
        return dp[n];
    }
}
