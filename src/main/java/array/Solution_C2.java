package array;

import java.util.Scanner;

public class Solution_C2 {


    /**
     * 开发商购买土地
     *
     * @param args
     */
    public static void main(String[] args) {
        new Solution_C2().solution();
    }


    private void solution() {
        // 数组大小
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] array = new int[n][m];

        // 数组元素值，同时求得数组元素值总和
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = scanner.nextInt();
                sum += array[i][j];
            }
        }

        // 行优先进行计算，找到最接近数组元素总和一半的位置
        int sumTemp = 0;
        int gap = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sumTemp += array[i][j];
            }
            gap = Math.min(gap, Math.abs(sum / 2 - sumTemp));
        }

        // 列优先进行计算
        sumTemp = 0;
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                sumTemp += array[i][j];
            }
            gap = Math.min(gap, Math.abs(sum / 2 - sumTemp));
        }

        // 输出
        System.out.println(gap);
    }
}
