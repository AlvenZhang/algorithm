package com.algorithm.leetcode_100days;

public class Solution009 {


    /**
     * 回文数
     * 给定一个整数，如果是回文数则返回true；否则返回false
     * 回文数就是正着读倒着读都是一样的数
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution009 solution009 = new Solution009();
        boolean palindrome = solution009.isPalindrome2(12321);
        System.out.println(palindrome);
    }


    /**
     * 转换成String，然后遍历一遍
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

    /**
     * 转换成String的过程速度很慢
     * 这里考虑直接将数字反转，然后进行比较。相等则返回true
     *
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        long res = 0;
        int temp = x;
        while (temp > 0) {
            res *= 10;
            res += temp % 10;
            temp /= 10;
        }
        return res == x;
    }
}
