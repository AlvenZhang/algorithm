package hash;

import java.util.*;

public class Solution349 {


    public static void main(String[] args) {
        int[] intersection = new Solution349().intersection(new int[]{1,2,2,1}, new int[]{2,2});
        for (int i : intersection) {
            System.out.print(i);
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }

        HashSet<Integer> resSet = new HashSet<>();
        for (int i : nums2) {
            if (set1.contains(i)){
                resSet.add(i);
            }
        }

        int[] res = new int[resSet.size()];
        int pos = 0;
        for (Integer i : resSet) {
            res[pos++] = i;
        }
        return res;
    }
}
