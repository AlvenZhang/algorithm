package array;


import java.util.Scanner;

public class Solution_C01 {

    /**
     * 给定一个整数数组 Array，请计算该数组在每个指定区间内元素的总和。
     *
     * @param args
     */
    public static void main(String[] args) {
        new Solution_C01().solution();
    }

    private void solution() {
        Scanner scanner = new Scanner(System.in);

        // 数组长度
        int num = scanner.nextInt();
        int[] array = new int[num];

        // 循环接收数组元素内容
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        // 循环接收区间
        while (scanner.hasNext()) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            // 计算区间和
            int sum = 0;
            for (int i = left; (i < array.length && i <= right); i++) {
                sum+=array[i];
            }
            System.out.println(sum);
        }
    }
}
