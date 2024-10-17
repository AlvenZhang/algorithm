package twopointer;

public class Solution283 {


    /**
     * 将非零数字向前移动
     * 使用k记录需要向前移动的元素数，初始值为0
     * 最后将后k个值设置为0
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            // 将非零数字向前移动
            nums[i - k] = nums[i];
            if (nums[i] == 0) {
                k++;
            }
        }
        // 将后k个值设置为0
        for (int i = 1; i <= k; i++) {
            nums[nums.length - i] = 0;
        }
    }
}
