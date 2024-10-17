package hash;

import java.util.HashSet;

public class Solution128 {


    public static void main(String[] args) {

    }

    /**
     * 将数组中所有值都放到set中
     * 遍历set
     * <p>
     * 超出时间限制，该方法最大时间复杂度为O(n^2)
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (Integer i : set) {
            int tempSize = 1;
            while (set.contains(++i)) {
                tempSize++;
            }
            res = Math.max(tempSize, res);
        }

        return res;
    }

    public int longestConsecutive2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (Integer i : set) {
            int tempSize = 1;

            /*************************/
            // 剪枝
            if (set.contains(i - 1)) {
                continue;
            }
            /************************/
            while (set.contains(++i)) {
                tempSize++;
            }
            res = Math.max(tempSize, res);
        }

        return res;
    }
}
