package com.algorithm.leetcode_100days;

public class Solution029 {


    /**
     * 两数相除
     * 中等
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution029 solution029 = new Solution029();
        int divide = solution029.divide(-2147483648, -1);
        System.out.println(divide);
    }


    /**
     * 被除数不断减去除数，累计减法的次数
     * 直至被除数不够减
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        long res = 0;
        int flag = -1;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            flag = 1;
        }
        long dividend_1 = dividend;
        dividend_1 = Math.abs(dividend_1);
        long divisor_1 = divisor;
        divisor_1 = Math.abs(divisor_1);

        while (dividend_1 > 0 && dividend_1 - divisor_1 >= 0) {
            res++;
            dividend_1 -= divisor_1;
        }
        if (res > Integer.MAX_VALUE){
            res = Integer.MAX_VALUE;
        }
        return (int)(flag > 0 ? res : -res);
    }
}
