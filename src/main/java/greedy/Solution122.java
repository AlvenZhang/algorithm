package greedy;

public class Solution122 {

    public static void main(String[] args) {
        int i = new Solution122().maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(i);
    }

    /**
     * 计算出每天的利润，然后计算所有正利润之和即为最后的答案
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 计算每天的利润
        int len = prices.length;
        int sum = 0;
        for (int i = 1; i < len; i++) {
            int sub = prices[i] - prices[i - 1];
            if (sub > 0) {
                sum += sub;
            }
        }
        return sum;
    }
}
