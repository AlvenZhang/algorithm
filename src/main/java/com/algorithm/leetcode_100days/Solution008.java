package com.algorithm.leetcode_100days;

import com.sun.org.glassfish.external.probe.provider.PluginPoint;

import java.security.Principal;

public class Solution008 {


    /**
     * 字符串转换整数
     *
     * @param args
     */
    public static void main(String[] args) {
        int res = new Solution008().myAtoi2(" -1010023630o4");
        System.out.println(res);
    }


    /**
     * 本方法题意理解有问题
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        Integer flag = 1;
        Integer res = 0;
        // 正负号的个数
        Integer count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Integer.MAX_VALUE / 10 < res) {
                if (flag == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            if (s.charAt(i) != ' ') {
                if ((int) s.charAt(i) == 45) {
                    if (count == 1)
                        return 0;
                    count++;
                    flag = -1;
                    continue;
                } else if (Integer.valueOf(s.charAt(i)) == 43) {
                    if (count == 1)
                        return 0;
                    count++;
                    continue;
                } else if (Integer.valueOf(s.charAt(i)) > 57 || Integer.valueOf(s.charAt(i)) < 48) {
                    return res;
                }
                res *= 10;
                res += Integer.valueOf(s.charAt(i)) - 48;
            }
        }
        return res * flag;
    }

    /**
     * 1. 跳过空格
     * 2. 开始判断，如果有非数字，直接结束
     *
     * @param s
     * @return
     */
    public int myAtoi2(String s) {
        if (s.isEmpty())
            return 0;

        int flag = 1;
        int res = 0;

        int pointer = 0;
        for (; pointer < s.length(); pointer++) {
            if (s.charAt(pointer) != ' ')
                break;
        }

        if (pointer >= s.length())
            return 0;
        // 整理数字
        if (s.charAt(pointer) == '+') {
            pointer++;
        } else if (s.charAt(pointer) == '-') {
            flag = -1;
            pointer++;
        }
        for (; pointer < s.length(); pointer++) {
            // 检测是否溢出
            if (Integer.MAX_VALUE / 10 < res) {
                if (!isNumber(s.charAt(pointer)))
                    return res * flag;
                if (flag == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }else if (Integer.MAX_VALUE / 10 == res){
                if (flag == 1 && (int) s.charAt(pointer) -48 >= 7) {
                    return Integer.MAX_VALUE;
                } else if (flag == -1 && (int) s.charAt(pointer) -48 >= 8){
                    return Integer.MIN_VALUE;
                }
            }
            if (!isNumber(s.charAt(pointer))) {
                return res * flag;
            }
            res *= 10;
            res += (int) s.charAt(pointer) - 48;
        }
        return res * flag;
    }


    private boolean isNumber(char ch){
        if ((int) ch <= 57 && (int) ch >= 48) {
            return true;
        }
        return false;
    }

    /**
     * 方法三：
     *  可以直接使用trim方法将首尾的空格去除
     *  使用long来存储遍历结果，最后再判断是否溢出
     */
}
