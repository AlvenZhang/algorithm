package com.algorithm.leetcode_100days;

import com.sun.org.apache.regexp.internal.REUtil;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;

public class Solution044 {


    /**
     * 通配符匹配
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution044 solution044 = new Solution044();
        boolean match = solution044.isMatch2("abcabczzzde", "*abc???de*");
        System.out.println(match);
    }

    /**
     * 同时遍历两个字符串，根据规则进行推进
     * <p>
     * 无法解决"abcabczzzde", "*abc???de*"
     *
     * @param s 字符串
     * @param p 字符模式
     * @return
     */
    public boolean isMatch(String s, String p) {
        // 字符串和字符模式的索引
        int i = 0;
        int j = 0;

        // 同时遍历两个字符串
        while (i < s.length() && j < p.length()) {
            if (p.charAt(j) == '?') {
                // 匹配任意一个字符，直接两者都推进
                i++;
                j++;
            } else if (p.charAt(j) == '*') {
                // 匹配字符串中任意数量的任意字符
                // 如果此字符模式元素后边没有其他元素，则直接返回true
                if (j == p.length() - 1) {
                    return true;
                }
                // 字符模式元素后边还有其他元素，则在字符串中寻找该元素
                while (j < p.length() - 1 && i < s.length()) {
                    // *可以匹配空字符串，所以i不用提前增加
                    if (p.charAt(j + 1) == s.charAt(i)) {
                        // 匹配，同时推进
                        i++;
                        j += 2;
                        break;
                    } else {
                        // 字符串中元素不匹配，但可以算作匹配*
                        i++;
                    }
                }
            } else {
                // 字符模式元素不是通配符
                if (s.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            }
        }
        while (j < p.length()) {
            if (p.charAt(j) != '*') {
                return false;
            }
            j++;
        }
        return i == s.length() && j == p.length();
    }

    /**
     * 看不懂动态规划
     * 想一下直接的暴力求解
     * 想不到
     */


    /**
     *
     * 动态规划，状态转移方程：
     * dp[i][j] = dp[i][j-1]||dp[i-1][j], p_j==*
     ************ dp[i-1][j-1], p_j==?||s_i==p_j
     ************ False, 字符不匹配的情况
     *
     * 如果p_j==*
     * dp[i][j-1]前i个字符能否跟前j-1个模式串匹配，只用*之前的模式串就可以匹配
     * dp[i-1][j]前i-1个字符能否跟前j个模式串匹配，使用*可以跟前i-1个字符串匹配，自然也可以跟前i个字符串匹配
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 初始化边界条件
        dp[0][0] = true;
        // 初始，s为空串，p不为空时的dp
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                // s为空，但是p_i是*。则dp应该为true，因为可以匹配
                dp[0][i] = true;
            } else {
                // s为空，dp不是*。不匹配。默认值false
                // 有一个不匹配，后边必然也不匹配，为false
                break;
            }
        }

        // 动态规划
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
