package com.algorithm.leetcode_100days;

public class Solution020 {


    /**
     * 有效的括号
     * @param args
     */
    public static void main(String[] args) {
        Solution020 solution020 = new Solution020();
        boolean valid = solution020.isValid("]");
        System.out.println(valid);
    }


    /**
     * 使用栈进行处理
     * 遇到左括号则入栈，遇到右括号则出栈并判断括号是否匹配
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        // 使用字符数组模拟栈结构
        char[] stack = new char[s.length()];
        int pointer = 0;

        for (int i = 0; i < s.length(); i++) {
            // 左括号，入栈
            if (s.charAt(i) == '('||s.charAt(i) == '{'||s.charAt(i) == '['){
                stack[pointer++] = s.charAt(i);
                continue;
            }
            // 右括号，出栈并判断
            if (s.charAt(i) == ')'){
                if (pointer == 0){
                    return false;
                }
                if (stack[--pointer] != '(')
                    return false;
            } else if (s.charAt(i) == '}'){
                if (pointer == 0){
                    return false;
                }
                if (stack[--pointer] != '{')
                    return false;
            } else if (s.charAt(i) == ']'){
                if (pointer == 0){
                    return false;
                }
                if (stack[--pointer] != '[')
                    return false;
            }
        }
        return pointer == 0;
    }
}
