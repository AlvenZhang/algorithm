package greedy;

public class Solution053 {
    public static void main(String[] args) {
        Solution053 solution053 = new Solution053();
        int i = solution053.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(i);
    }


    /**
     * 暴力破解是确定一个起点，然后再有一个循环去计算从起点开始的和
     * 贪心算法贪心的是在 **一旦数组之和为负数就只能对后续的数组值和起减小作用** ，所以一旦数组之和为负数就将其抛弃，将下一个位置作为起点，重新开始计算
     * 注意：这里发现数组之和为负数之后，就从下一个位置重新开始计算，而不是回到上一个起点然后后移继续
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int len = nums.length;
        int max = Integer.MIN_VALUE;
        // 遍历起点
        int sum = 0;
        for (int i = 0; i < len; i++) {
            // 计算数组之和
            sum += nums[i];
            if (max < sum) {
                max = sum;
            }
            if (sum < 0){
                // 数组之和为负数，重新开始计算
                sum = 0;
            }
        }
        return max;
    }
}
