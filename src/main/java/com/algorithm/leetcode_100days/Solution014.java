package com.algorithm.leetcode_100days;

public class Solution014 {


    /**
     * 最长公共前缀
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution014 solution014 = new Solution014();
        String s = solution014.longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(s);
    }


    /**
     * 遍历每个字符串，从开始位置判断同一位置字符是否相同，输出相同部分
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int maxLength = 0;
        int strMinLength = Integer.MAX_VALUE;
        // 遍历得到字符串数组中，最短字符串的长度
        for (String str : strs) {
            if (strMinLength > str.length()) {
                strMinLength = str.length();
            }
        }

        // 判断公共前缀的长度
        for (int i = 0; i < strMinLength; i++) {
            for (String str : strs) {
                if (str.charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, maxLength);
                }
            }
            maxLength++;
        }

        return strs[0].substring(0, maxLength);
    }

}
