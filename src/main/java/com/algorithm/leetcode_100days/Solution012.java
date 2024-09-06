package com.algorithm.leetcode_100days;

import java.lang.reflect.Array;

public class Solution012 {


    /**
     * 整数转罗马数字
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution012 solution012 = new Solution012();
        String s = solution012.intToRoman2(3);
        System.out.println(s);
    }

    /**
     * 暴力求解：使用两个数组记录罗马数字与整数的对应关系。将所要求的整数，不断减去能减去的最大罗马数
     * 动态规划：从较小的数字不断增加，直到所要求的数字。使用dp记录
     * dp[operator] = romanArray[i] + dp[operator-i]
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] numArray = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romanArray = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        String[] dp = new String[num + 1];
        // 初始化dp
//        dp[1] = "I";
//        this.initDP(dp, num);
        for (int operator = 1; operator <= num; operator++) {
//            if (dp[operator] == null) {
            for (int i = numArray.length - 1; i >= 0; i--) {
                if (operator >= numArray[i]) {
                    dp[operator] = romanArray[i] + (dp[operator - numArray[i]] != null ? dp[operator - numArray[i]] : "");
                    break;
                }
            }
//            }
        }

        return dp[num];
    }


    /**
     * woshichunzhu
     * 直接暴力求解比动态规划简单多了，根本算不上一个中等难度题
     * 按照高位减到低位
     *
     * @param num
     * @return
     */
    public String intToRoman2(int num) {
        int[] numArray = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romanArray = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = numArray.length - 1; i >= 0; ) {
            if (num >= numArray[i]){
                stringBuilder.append(romanArray[i]);
                num -= numArray[i];
            }else {
                i--;
            }
        }
        return stringBuilder.toString();
    }

    private void initDP(String[] dp, int num) {
        if (num >= 1)
            dp[1] = "I";
        if (num >= 2)
            dp[2] = "II";
        if (num >= 3)
            dp[3] = "III";
        if (num >= 4)
            dp[4] = "IV";
        if (num >= 5)
            dp[5] = "V";
        if (num >= 9)
            dp[9] = "IX";
        if (num >= 10)
            dp[10] = "X";
        if (num >= 40)
            dp[40] = "XL";
        if (num >= 50)
            dp[50] = "L";
        if (num >= 90)
            dp[90] = "XC";
        if (num >= 100)
            dp[100] = "C";
        if (num >= 400)
            dp[400] = "CD";
        if (num >= 500)
            dp[500] = "D";
        if (num >= 900)
            dp[900] = "CM";
        if (num >= 1000)
            dp[1000] = "M";
    }
}
