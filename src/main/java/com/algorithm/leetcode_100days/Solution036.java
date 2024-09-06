package com.algorithm.leetcode_100days;

public class Solution036 {

    /**
     * 有效的数独
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution036 solution036 = new Solution036();
        char[][] board = new char[][]{
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'}, {
                '.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'}, {
                '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        boolean validSudoku = solution036.isValidSudoku(board);
        System.out.println(validSudoku);
    }

    /**
     * 上来就只想到了暴力求解
     * <p>
     * 题解做法：一次遍历
     * 使用两个二维数组，一个三维数组，分别记录index在board中每一行、每一列、每个小九宫格中出现的次数
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '0' - 1;
                    rows[i][index] += 1;
                    columns[j][index] += 1;
                    subboxes[i / 3][j / 3][index] += 1;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
