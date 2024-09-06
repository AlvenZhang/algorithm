package array;

public class Solution209 {

    /**
     * 输出长度最小子数组的长度
     *
     * 使用滑动窗口，但是调试了很多次都出不来，头晕脑胀
     * @param args
     */
    public static void main(String[] args) {
        int i = new Solution209().minSubArrayLen(11, new int[]{1, 2, 3, 4, 5});
        System.out.println(i);
    }

    public int minSubArrayLen(int target, int[] nums) {

        int begin = 0, end = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        for (; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                res = Math.min(res, (end - begin + 1));
                sum -= nums[begin++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
