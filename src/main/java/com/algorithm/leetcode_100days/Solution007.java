package com.algorithm.leetcode_100days;

public class Solution007 {

    /**
     * 整数反转
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution007 solution007 = new Solution007();
        int reverse = solution007.reverse(1534236469);
        System.out.println(reverse);
    }

    /**
     * 1. 将x%10，得到一位数并存储。并将x/10
     * 2.
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        if (x == 0)
            return x;

        // 保存正负号
        Integer flag = x > 0 ? 1 : -1;

        x = Math.abs(x);
        Integer ans = 0;
        while (x > 0) {
            if (Integer.MAX_VALUE/10 < ans){
                return 0;
            }

            ans *= 10;
            ans += x % 10;
            x /= 10;
            // 判断是否溢出
        }
        return ans * flag;
    }
}
