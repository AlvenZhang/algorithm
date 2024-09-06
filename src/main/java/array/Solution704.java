package array;

public class Solution704 {

    /**
     * 二分查找
     * <p>
     * 先找到中间值，比较中间值与target的大小，进一步确定查找范围。重复上述操作
     *
     * 使用了两种方法，search是递归；search2是常规用法，循环，就是使用search，没有人会用递归，都很快
     *
     * @param args
     */
    public static void main(String[] args) {
        int search = new Solution704().search2(new int[]{-1, 0, 3, 5, 9, 12}, 2);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        return helper(nums, target, 0, nums.length - 1);
    }

    private int helper(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] < target) {
            start = mid + 1;
        } else if (nums[mid] > target) {
            end = mid - 1;
        } else {
            return mid;
        }
        return helper(nums, target, start, end);
    }

    public int search2(int[] nums, int target) {
        if (nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
