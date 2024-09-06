package hash;

import java.util.HashMap;

public class Solution454 {


    public static void main(String[] args) {

    }


    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        // 统计前两个数组和的Map，kei为和，value为和出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int i1 : nums2) {
                int sumTemp = i + i1;
                map.put(sumTemp, map.getOrDefault(sumTemp, 0) + 1);
            }
        }

        // 记录满足元组的个数
        int resCount = 0;
        for (int i : nums3) {
            for (int i1 : nums4) {
                int sumTemp = i + i1;
                resCount += map.getOrDefault(-sumTemp, 0);
            }
        }
        return resCount;
    }
}
