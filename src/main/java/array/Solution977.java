package array;

import java.util.Arrays;

public class Solution977 {
    /**
     * 有序数组的平方，输出要求仍然有序
     *
     * 法一：先求平方，后排序
     * 法二：双指针法，分别指向数组两端，将每次两个指针比较取得较大的值
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution977().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }


    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortedSquares2(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int pointer = nums.length - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                res[pointer--] = nums[left] * nums[left];
                left++;
            } else {
                res[pointer--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}
