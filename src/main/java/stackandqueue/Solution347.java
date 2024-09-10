package stackandqueue;

import java.awt.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Solution347 {


    public static void main(String[] args) {
        int[] ints = new Solution347().topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        for (int anInt : ints) {
            System.out.print(anInt);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int i = 0; i < k; i++) {
            int max = Integer.MIN_VALUE;
            int maxKey = 0;
            for (Integer integer : map.keySet()) {
                Integer i1 = map.get(integer);
                if (i1 > max) {
                    max = i1;
                    maxKey = integer;
                }
            }
            map.remove(maxKey);
            res[i] = maxKey;
        }
        return res;
    }

}
