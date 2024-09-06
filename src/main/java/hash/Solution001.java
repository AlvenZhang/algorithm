package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Solution001 {


    public static void main(String[] args) {
        int[] ints = new Solution001().twoSum(new int[]{}, 1);
        for (int anInt : ints) {
            System.out.print(anInt);
        }
    }


    public int[] twoSum(int[] nums, int target) {
        // 将nums放入map
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
