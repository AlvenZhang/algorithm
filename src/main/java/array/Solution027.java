package array;

public class Solution027 {

    /**
     * 移除数组中数值等于val的元素，并返回剩余元素的个数。注意需要原地操作
     *
     * 记录数值等于val的元素的个数k，将每个元素向前移动k个位置
     * 返回值使用nums.length() - k
     * @param args
     */
    public static void main(String[] args) {
        int i = new Solution027().removeElement(new int[]{3,2,2,3}, 3);
        System.out.println(i);
    }

    public int removeElement(int[] nums, int val) {
        // 使用k记录nums中val同值的元素个数，将每个元素向前移动k个位置
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i-k] = nums[i];
            if (nums[i] == val){
                k++;
            }
        }
        return nums.length - k;
    }
}
