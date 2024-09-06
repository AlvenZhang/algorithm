package greedy;

import sun.font.TrueTypeFont;

import java.util.Currency;

public class Solution045 {

    public static void main(String[] args) {
        System.out.println(new Solution045().jump(new int[]{1, 2}));
    }

    /**
     * 仍然像跳跃游戏Ⅰ一样，尽可能去多覆盖范围。只要范围覆盖到了不管怎么跳，总可以跳到终点
     *
     * @param nums
     * @return
     */

    public int jump(int[] nums) {

        // 跳跃次数
        int count = 1;
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int cover = nums[0];
        int subCover = 0;
        for (int i = 1; i < len; i++) {
            subCover = Math.max(i + nums[i], subCover);
            if (cover >= len - 1) {
                return count;
            }
            // 到达边界，重置最大cover
            if (i == cover) {
                count++;
                cover = subCover;
            }
        }
        return count;
    }

}
