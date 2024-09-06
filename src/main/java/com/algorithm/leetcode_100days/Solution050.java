package com.algorithm.leetcode_100days;

public class Solution050 {

    public static void main(String[] args) {
        double v = new Solution050().myPow2(2.00000, -2147483648);
        System.out.println(v);
    }

    /**
     * 连续进行乘法
     * <p>
     * 超出时间限制
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 1) return 1;
        if (n == 0) {
            return 1;
        } else {
            if (n < 0) {
                x = 1 / x;
            }

            double x1 = x;
            for (int i = 0; i < Math.abs(n) - 1; i++) {
                x1 = x1 * x;
            }

            return x1;
        }

    }

    /**
     * 快速幂（递归）
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {

        return n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);

    }

    private double quickMul(double x, int n) {

        if (n == 0) {
            return 1.0;
        }

        double y = quickMul(x, n / 2);

        return n % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * 快速幂（迭代）
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        long N = n;
        return n >= 0 ? quickMul1(x, N) : 1.0 / quickMul1(x, -N);
    }

    private double quickMul1(double x, long n) {
        double ans = 1.0;
        // 定义贡献的初始值是x
        double contribute = x;

        while (n > 0) {
            if (n % 2 == 1) {
                // 计入贡献
                ans *= contribute;
            }
            // 贡献平方
            contribute *= contribute;
            // 去掉最低位
            n /= 2;
        }
        return ans;
    }

}
