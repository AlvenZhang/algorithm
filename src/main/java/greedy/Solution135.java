package greedy;

public class Solution135 {


    /**
     * 从左往右遍历的时候判断右边小孩比左边小孩大的情况
     * 从有往左遍历的时候判断左边小孩比右边小孩大的情况
     *
     * 只知道按照这个规律可以解题，但还不知道为什么这样可以解
     * @param args
     */
    public static void main(String[] args) {
        int candy = new Solution135().candy(new int[]{1, 3, 4, 5, 2});
        System.out.println(candy);
    }


    /**
     * 相邻两个还是评分更高的会得到更多糖果
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        // 记录糖果总数
        int count = 0;
        // 记录每个人的糖果数量
        int[] candyNum = new int[ratings.length];
        // 初始化
        for (int i = 0; i < candyNum.length; i++) {
            candyNum[i] = 1;
        }

        // 遍历rating，右边小孩比左边小孩大
        for (int i = 0; i < ratings.length - 1; i++) {
            // 相邻更高评分获得更多糖果
            if (ratings[i + 1] > ratings[i]) {
                candyNum[i + 1] = candyNum[i] + 1;
            }
        }
        // 反向遍历，左边小孩比右边小孩大
        for (int i = ratings.length - 1; i > 0; i--) {
            // 相邻更高评分获得更多糖果
            if (ratings[i - 1] > ratings[i]) {
                if (candyNum[i - 1] < candyNum[i] + 1) {
                    candyNum[i - 1] = candyNum[i] + 1;
                }
            }
        }
        for (int j : candyNum) {
            count += j;
        }
        return count;
    }
}