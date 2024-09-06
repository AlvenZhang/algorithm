package com.algorithm.leetcode_100days;

import java.util.Stack;

public class Solution032 {


    /**
     * 最长有效括号
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution032 solution032 = new Solution032();
        int i = solution032.longestValidParentheses("()(()");
        System.out.println(i);
    }


    /**
     * 左括号入栈，右括号括号出栈。每次出栈入栈都count++
     * 栈空但是仍然碰到右括号，则count=0，记录maxCount
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        char[] arr = new char[s.length()];
        // 表示栈中元素的个数
        int pointer = 0;
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // 入栈
            if (s.charAt(i) == '(') {
                arr[pointer++] = '(';
            } else if (s.charAt(i) == ')') {
                if (pointer > 0 && arr[pointer - 1] == '(') {
                    pointer--;
                    count += 2;
                    if (maxCount < count){
                        maxCount = count;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return maxCount;
    }
}
