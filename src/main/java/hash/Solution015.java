package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution015 {

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution015().threeSum2(new int[]{0,0,0,0});
        System.out.println(lists.toString());
    }

    /**
     * 三数之和
     * 先确定一个数字的位置，然后移动另外两个。移动的时候注意位置不能重复
     * <p>
     * 超出时间限制
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int i1 = i + 1; i1 < nums.length - 1; i1++) {
                if (i1 > i + 1 && nums[i1] == nums[i1 - 1]) {
                    continue;
                }
                for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                    if (i2 > i1 + 1 && nums[i2] == nums[i2 - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[i1] + nums[i2] == 0) {
                        ArrayList<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[i1]);
                        tempList.add(nums[i2]);
                        res.add(tempList);
                    }
                }
            }
        }
        return res;
    }

    /**
     * 双指针
     * 先排序；i = 0， left=i+1， right指向数组末尾。如果i、left与right指向数组值的和大于0， 则right向左移动，反之left向右移动
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length-1;
            // 去重操作
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            while (left != right){
                int sum = nums[i] + nums[left] + nums[right];
                // 去重操作
                if (left > i+1 && nums[left] == nums[left-1]){
                    left++;
                    continue;
                }else if (right<nums.length-2 && nums[right] == nums[right+1]){
                    right--;
                    continue;
                }
                if (sum == 0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    left++;
//                    break;
                }else if (sum < 0){
                    left++;
                }else {
                    right--;
                }
            }
        }

        return res;
    }


}
