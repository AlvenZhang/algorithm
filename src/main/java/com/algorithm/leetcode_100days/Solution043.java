package com.algorithm.leetcode_100days;

import java.util.Arrays;
import java.util.Objects;

public class Solution043 {

    public static void main(String[] args) {
        Solution043 solution043 = new Solution043();
        String multiply = solution043.multiply2("123", "456");
        System.out.println(multiply);
    }


    /**
     * 直观的想法
     * 倒序遍历两个字符串，然后分别对每个字符进行乘法
     * <p>
     * 结果：数值太大，总是超过数字表示的上限
     * <p>
     * 使用字符串代替double、long等类型可以解决字符串超过上限的问题
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {

        if (Objects.equals(num1, "0") || Objects.equals(num2, "0")) {
            return "0";
        }

        // 记录乘法过程的中间值
        String[] tempArray = new String[num1.length()];
        // 中间值数组的索引
        int index = 0;
        //
        int ten = 0;
        // 倒序遍历两个字符串
        for (int i = num1.length() - 1; i >= 0; i--) {
            // 记录进位值
            double surplus = 0;
            // 临时记录中间值
            StringBuilder temp = new StringBuilder();
            int pow = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                // 进行乘法运算
                double res = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + surplus;
                // 进位
                if (res >= 10) {
                    surplus = Math.floor(res / 10);
                    res %= 10;
                } else {
                    surplus = 0;
                }
                // 得到中间值
                temp = temp.insert(0, (int) res);
            }
            if (surplus != 0) {
                temp = temp.insert(0, (int) surplus);
            }
            // 存储中间值
            for (int j = 0; j < ten; j++) {
                temp.append(0);
            }
            String s = temp.toString();
            tempArray[index++] = temp.substring(0, temp.length());
            ten++;
        }

        // 将所有临时值相加（字符串加法）
        String sum = "";

        for (String s : tempArray) {
            StringBuilder tempSum = new StringBuilder();
            int i = s.length() - 1;
            int j = sum.length() - 1;
            double tempPlus = 0;
            while (i >= 0 && j >= 0) {
                double temp = (s.charAt(i) - '0') + (sum.charAt(j) - '0') + tempPlus;
                tempPlus = Math.floor(temp / 10);
                tempSum.insert(0, String.valueOf(temp % 10).substring(0, String.valueOf(temp % 10).length() - 2));

                i--;
                j--;
            }
            while (i >= 0) {
                double temp = (s.charAt(i) - '0') + tempPlus;
                tempPlus = Math.floor(temp / 10);
                tempSum.insert(0, String.valueOf(temp % 10).substring(0, String.valueOf(temp % 10).length() - 2));
                i--;
            }
            while (j >= 0) {
                double temp = (sum.charAt(j) - '0') + tempPlus;
                tempPlus = Math.floor(temp / 10);
                tempSum.insert(0, String.valueOf(temp % 10).substring(0, String.valueOf(temp % 10).length() - 2));

                j--;
            }
            if (tempPlus != 0) {
                tempSum.insert(0, (int) tempPlus);
            }
            sum = tempSum.toString();
        }

        return sum;
    }


    /**
     * 第一种使用字符串解决溢出的问题，导致浪费时间、操作步骤过多
     * 这里可以使用整型数组代替前边方法的temp用来暂存结果，将每次乘法的结果直接加到数组中。最后数组中结果就是最终结果
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply2(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        // 结果暂存数组
        int[] cacheArray = new int[m + n];

        // 遍历两个乘数，将其每位的乘法结果累加到cacheArray中
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mulTemp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                cacheArray[i + j + 1 - 1] += (mulTemp / 10);
                cacheArray[i + j + 1] += (mulTemp % 10);
            }
            // 进位，保证每个数组元素中只包含一位数
            for (int j = cacheArray.length - 1; j >= 0; j--) {
                if (cacheArray[j] >= 10) {
                    cacheArray[j - 1] += cacheArray[j] / 10;
                    cacheArray[j] %= 10;
                }
            }
        }

        // 将cacheArray中的结果转换为字符串
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cacheArray.length; i++) {
            if (cacheArray[i] == 0) {
                continue;
            }
            while (i < cacheArray.length) {
                res.append(cacheArray[i++]);
            }
        }

        return res.toString();
    }
}
