package com.algorithm.leetcode_100days;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Solution017 {

    /**
     * 电话号码的字母组合
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution017 solution017 = new Solution017();
        List<String> strings = solution017.letterCombinations2("");
        System.out.println(strings.toString());
    }


    /**
     * 暴力解法
     * 指定字符串中每个数字分别代表的字母
     * 然后遍历取全集
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        String[] strs = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            strs[i] = this.digital2Letter(digits.charAt(i));
        }
        // 作为遍历的索引
        int[] len = new int[digits.length()];
        ArrayList<String> res = new ArrayList<>();
        // 记录当前遍历的是哪个字符串
        int pointer = len.length - 1;
        while (len[0] < strs[0].length()) {
            StringBuilder stringBuilder = new StringBuilder();
            // 拼接组成字符串
            for (int j : len) {
                stringBuilder.append(strs[j]);
            }

            // 更新索引值
            if (len[pointer] < strs[pointer].length()) {
                // 当前位置的字母还没遍历完
                len[pointer]++;
            } else {
                // 当前位置的字母已经遍历完
                // 如果当前位置索引是0，则结束遍历

                // 当前位置索引不是0，
                len[pointer] = 0;
                pointer--;
            }
        }
        return null;
    }

    private String digital2Letter(int num) {
        num -= 48;
        if (num == 2) {
            return "abc";
        } else if (num == 3) {
            return "def";
        } else if (num == 4) {
            return "ghi";
        } else if (num == 5) {
            return "jkl";
        } else if (num == 6) {
            return "mno";
        } else if (num == 7) {
            return "pqrs";
        } else if (num == 8) {
            return "tuv";
        } else if (num == 9) {
            return "wxyz";
        }
        return "";
    }

    /**
     * 深度优先遍历
     *
     * 不知道为什么运行时间很慢
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();
        // 取得数字对应的字符
        String[] strs = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            strs[i] = this.digital2Letter(digits.charAt(i));
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < strs[0].length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(strs[0].charAt(i));
            deepT(strs, 1, stringBuilder, res);
        }
        return res;
    }

    private void deepT(String[] strs, int pointer, StringBuilder sb, List<String> res) {
        if (pointer == strs.length) {
            res.add(sb.toString());
        } else {
            for (int i = 0; i < strs[pointer].length(); i++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(sb.toString() + strs[pointer].charAt(i));
                deepT(strs, pointer + 1, stringBuilder, res);
            }
        }
    }
}
