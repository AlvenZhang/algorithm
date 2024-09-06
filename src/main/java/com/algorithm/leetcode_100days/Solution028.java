package com.algorithm.leetcode_100days;

public class Solution028 {

    /**
     * 找出字符串中第一个匹配项的下标
     * @param args
     */
    public static void main(String[] args) {
        Solution028 solution028 = new Solution028();
        int i = solution028.strStr2("aaa", "aaaa");
        System.out.println(i);
    }

    /**
     * 暴力求解
     * 逐个子串匹配
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                // 第j个字符跟第i+j个进行比较
                try {
                    if (needle.charAt(j) != haystack.charAt(i+j)){
                        break;
                    }
                }catch (StringIndexOutOfBoundsException e){
                    return -1;
                }
            }
            if (j >= needle.length()){
                return i;
            }
        }
        return -1;
    }

    /**
     * 利用Java语法糖
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 使用KMP求解
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr3(String haystack, String needle) {
        return 1;
    }

}
