package com.algorithm.leetcode_100days;

public class Solution058 {


    /**
     * 最后一个单词的长度
     * @param args
     */
    public static void main(String[] args) {
        Solution058 solution058 = new Solution058();
        int i = solution058.lengthOfLastWord("Hello World");
        System.out.println(i);
    }


    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length-1].length();
    }
}
