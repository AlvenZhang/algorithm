package greedy;

public class Solution055 {

    public static void main(String[] args) {
        System.out.println(new Solution055().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    /**
     * 不去局限地考虑如何跳跃，而是考虑覆盖范围。也就是使用当前的跳跃次数最多可以跳到哪里
     * 如果最终能将终点覆盖那么表示最终可以跳跃到这里。
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int cover = 0;
        for (int i = 0; i < len && i <= cover; i++) {
            int subCover = i + nums[i];
            if (subCover > cover) {
                cover = subCover;
            }
            if (cover >= len - 1) {
                return true;
            }
        }
        return false;
    }
}
