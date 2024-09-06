package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution051 {

    public static void main(String[] args) {
        List<List<String>> lists = new Solution051().solveNQueens(4);
        System.out.println(lists.toString());
    }


    public List<List<String>> solveNQueens(int n) {
        char[][] room = new char[n][n];
        for (char[] chars : room) {
            Arrays.fill(chars, '.');
        }
        ArrayList<List<String>> ans = new ArrayList<>();
        backTracking(ans, 0, room);
        return ans;
    }

    private void backTracking(List<List<String>> ans, int l, char[][] room) {
        if (l >= room.length) {
            ArrayList<String> ansSub = new ArrayList<>();
            for (char[] chars : room) {
                ansSub.add(String.copyValueOf(chars));
            }
            ans.add(ansSub);
            return;
        }

        for (int i = 0; i < room.length; i++) {
            if (judge(l, i, room)) {
                room[l][i] = 'Q';
                backTracking(ans, l + 1, room);
                room[l][i] = '.';
            }
        }
    }


    // 判断放置位置是否合法
    private boolean judge(int row, int col, char[][] room) {
        // 检查行
        for (int i = 0; i < room.length; i++) {
            if (room[row][i] == 'Q') {
                return false;
            }
        }

        // 检查列
        for (int i = 0; i < room.length; i++) {
            if (room[i][col] == 'Q') {
                return false;
            }
        }


        /**
         * 检查斜线的时候只需要检查当前行上方，因为下方还未放置棋子
         */
        // 检查斜线1
//        for (int i = 0; col + i < room.length && row + i < room.length; i++) {
//            if (room[row + i][col + i] == 1) {
//                return false;
//            }
//        }
        for (int i = 0; col - i >= 0 && row - i >= 0; i++) {
            if (room[row - i][col - i] == 'Q') {
                return false;
            }
        }

        // 检查斜线2
        for (int i = 0; col + i < room.length && row - i >= 0; i++) {
            if (room[row - i][col + i] == 'Q') {
                return false;
            }
        }
//        for (int i = 0; col - i >= 0 && row + i < room.length; i++) {
//            if (room[row + i][col - i] == 1) {
//                return false;
//            }
//        }

        return true;
    }
}
