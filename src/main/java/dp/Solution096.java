package dp;

public class Solution096 {


    public static void main(String[] args) {
        System.out.println(new Solution096().numTrees(3));
    }

    /**
     * 三个结点的二叉搜索树：node1 -- node2 -- node3，node123都可以作为根节点
     * node1作为根节点时 = dp[0] * dp[2]
     * node2作为根节点时 = dp[1] * dp[1]
     * node3作为根节点时 = dp[2] * dp[0]
     * dp[3] = node1作为根节点时 + node2作为根节点时 + node3作为根节点时
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
