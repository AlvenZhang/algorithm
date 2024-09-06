package backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution017 {


    public static void main(String[] args) {
        List<String> strings = new Solution017().letterCombinations("23");
        System.out.println(strings);
    }


    public List<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<>();
        if (digits.isEmpty()){
            return ans;
        }
        List<Integer> nums = Arrays.stream(digits.split("")).map(Integer::valueOf).collect(Collectors.toList());
        backtracking(ans, new StringBuffer(), nums, 0);
        return ans;
    }

    void backtracking(List<String> ans, StringBuffer ansSub, List<Integer> nums, int index) {
        // 结束条件
        if (nums.size() == index) {
            ans.add(ansSub.toString());
            return;
        }

        // 遍历
        String strs = digital2Letter(nums.get(index));
        for (int i = 0; i < strs.length(); i++) {
            ansSub.append(strs.charAt(i));
            backtracking(ans, ansSub, nums, index + 1);
            // 恢复
            ansSub.deleteCharAt(ansSub.length()-1);
        }

    }

    private String digital2Letter(int num) {
//        num -= 48;
        if (num == 2) {
            return "abc";
        } else if (num == 3) {
            return "def";
        } else if (num == 4) {
            return "ghi";
        } else if (num == 5) {
            return "jkl";
        } else if (num == 6) {
            return "mno";
        } else if (num == 7) {
            return "pqrs";
        } else if (num == 8) {
            return "tuv";
        } else if (num == 9) {
            return "wxyz";
        }
        return "";
    }
}
