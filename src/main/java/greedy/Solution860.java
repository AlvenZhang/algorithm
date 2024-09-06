package greedy;

public class Solution860 {


    /**
     * 题目里面唯一的贪心策略是：优先选择10+5而不是5*3
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Solution860().lemonadeChange(new int[]{5,5,10,10,20}));
    }


    /**
     * 尽可能先将大面额的钞票找出
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        // 记录不同面额零钱数量
        int[] change = new int[3];

        // 遍历bill
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                change[0]++;
                continue;
            } else if (bills[i] == 10) {
                if (change[0] > 0) {
                    change[1]++;
                    change[0]--;
                    continue;
                }
                return false;
            } else {
                // 在change中凑够15。3*5或者10+5
                if (change[1] > 0 && change[0] > 0) {
                    change[0]--;
                    change[1]--;
                    change[2]++;
                    continue;
                } else if (change[0] > 2) {
                    change[0] -= 3;
                    change[2]++;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
