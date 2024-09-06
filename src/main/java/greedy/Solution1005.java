package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution1005 {

    public static void main(String[] args) {
        int i = new Solution1005().largestSumAfterKNegations(new int[]{4, -5, 4, -5, 9, 4, 5}, 1);
        System.out.println(i);
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        // 将数组按照绝对值大小排序
        nums = Arrays.stream(nums).boxed().sorted(Comparator.comparingInt(Math::abs)).mapToInt(Integer::intValue).toArray();


        // 从最小开始变换（如果最小部分是负数，那会变大，如果是整数，那么损失最小）
        for (int i = nums.length - 1; i > 0 && k > 0; i--) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        if (k % 2 != 0) {
            nums[0] = -nums[0];
        }

        // 求和
        return Arrays.stream(nums).sum();
    }
}
