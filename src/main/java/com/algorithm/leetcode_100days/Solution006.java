package com.algorithm.leetcode_100days;

import javafx.beans.binding.StringBinding;

public class Solution006 {

    /**
     * Z字形变换
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution006 solution006 = new Solution006();
        String s = solution006.convert2("PAYPALISHIRING", 3);
        System.out.println(s);
    }


    /**
     * 首先想到暴力破解
     * 1. 创建一个二维数组，将字符串按照顺序排列好
     * 1.1 排列方法：首先沿着列到最下行；然后每次向右换行换列到最上行；然后沿着列到最下行；重复
     * 也就是每到第一行时，就直着向下
     * 每到最后一行时，就斜着向上
     * 2. 逐行读取二维数组。空白用特殊字符代替（#）
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {

        if (numRows == 1)
            return s;

        // 1. 创建二维数组（数组自动初始化为0）
        char[][] array = new char[numRows][s.length()];

        Integer pointer = 0;    // 指针，指向字符串的字符位置
        Integer row = 0;    // 行号
        Integer col = 0;    // 列号

        // 2. 将字符进行Z字形排序
        array[0][0] = s.charAt(pointer);
        pointer++;
        while (pointer < s.length()) {
            if (row <= 0) {
                row = 1;
                for (; row < numRows; row++, pointer++) {
                    if (pointer >= s.length())
                        break;
                    array[row][col] = s.charAt(pointer);
                }
            } else if (row >= numRows) {
                row = numRows - 1 - 1;
                col++;
                for (; row >= 0; row--, col++, pointer++) {
                    if (pointer >= s.length())
                        break;
                    array[row][col] = s.charAt(pointer);
                }
            }
        }
        // 3. 对二维数组进行行优先读取
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (array[i][j] != 0) {
                    stringBuilder.append(array[i][j]);
                }
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 其实按照Z字形将字符排列在二维数组中，最后读取其顺序。就是将字符不断分配到指定的行中
     * 只要能确定将字符放到相应行中，则不非要按照Z字形分配。这样可以节省大量空间
     * 方法：
     *      直接不断换行分配字符。每行用列表承载数据。然后将每行按照先后顺序首尾相接
     * @param s
     * @param numRows
     * @return
     */
    public String convert2(String s, int numRows) {
        if (numRows == 1)
            return s;
        // 1. 定义并初始化数组
        StringBuilder[] ans = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            ans[i]  = new StringBuilder();
        }
        
        // 2. 排列字符
        Integer pos = 0;    // 位置
        Integer incre = 1;  // 增量
        for (int i = 0; i < s.length(); i++) {
            if (pos == 0){
                incre = 1;
            }else if (pos == numRows-1){
                incre = -1;
            }
            ans[pos].append(s.charAt(i));
            pos += incre;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(ans[i].toString());
        }

        return res.toString();
    }


}
