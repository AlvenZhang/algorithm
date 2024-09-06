package com.algorithm.leetcode_100days;

public class Solution010_未完成 {

    /**
     * 正则表达式匹配
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution010_未完成 solution010 = new Solution010_未完成();
        boolean abc = solution010.isMatch("abc", "a.");
        System.out.println(abc);
    }


    /**
     * 从题意上看，就是去匹配字符串
     * 首先暴力求解，用p去尝试匹配s的每个子串
     * 当然匹配子串可以使用 滑动窗口 来匹配
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        int head = 0;
        int tail = 0;
        int sub_point = 0;
        char last_char = ' ';

        // 尝试匹配子串，如果匹配成功则直接返回true
        while (head != s.length() - 1 && tail != s.length() - 1) {
            if (p.charAt(sub_point) == '.') {
                last_char = s.charAt(tail);
                tail++;
            } else if (p.charAt(sub_point) == '*') {

            }

        }

        return false;
    }


    /**
     * 动态规划
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        boolean[][] dp = new boolean[s.length()][p.length()];
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                dp[i][j] = dp[i - 1][j - 1];
                i++;
                j++;
            } else if (s.charAt(i) != p.charAt(j) && p.charAt(j) != '*') {
                return false;
            } else {

            }
        }

        return true;
    }
}
