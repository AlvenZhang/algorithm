package com.algorithm.leetcode_100days;

import java.rmi.MarshalException;
import java.util.Arrays;

public class Solution048 {

    /**
     * 原地旋转二维矩阵
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        new Solution048().rotate1(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 使用辅助数组进行旋转
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        // 创建辅助数组
        int[][] helper = new int[len][len];

        // 遍历每个元素
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                helper[j][len - i - 1] = matrix[i][j];
            }
        }

        // 复制
        for (int i = 0; i < len; i++) {
            System.arraycopy(helper[i], 0, matrix[i], 0, len);
        }
    }

    // 使用翻转解决问题
    public void rotate1(int[][] matrix) {
        int len = matrix.length;
        // 进行水平反转
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - i][j];
                matrix[len - 1 - i][j] = temp;
            }
        }

        // 进行主对角线反转
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
