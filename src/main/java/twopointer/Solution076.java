package twopointer;

import com.sun.org.apache.regexp.internal.REUtil;

import java.util.HashMap;
import java.util.Map;

public class Solution076 {

    public static void main(String[] args) {
        Solution076 solution076 = new Solution076();
        String s = solution076.minWindow("aa", "aa");
        System.out.println(s);
    }


    Map<Character, Integer> subMap = new HashMap<>();
    Map<Character, Integer> recordMap = new HashMap<>();

    /**
     * 使用滑动窗口解决
     * 使用map记录窗口中字串元素的出现次数
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }
        // 需要记录字串字符的个数
        for (int i = 0; i < t.length(); i++) {
            recordMap.put(t.charAt(i), recordMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 将子串放入map中，并赋初始数值为0
        for (int i = 0; i < t.length(); i++) {
            subMap.put(t.charAt(i), 0);
        }

        // 使用两个指针分别表示窗口左右边界
        int left = 0;
        int right = 0;

        // 记录最小窗口
        String res = "";
        int minSize = Integer.MAX_VALUE;

        if (subMap.containsKey(s.charAt(0))) {
            subMap.put(s.charAt(0), subMap.get(s.charAt(0)) + 1);
        }

        while (true) {

            // 如果map中有value为0，则右移右边界。否则右移左边界
            if (check()) {
                if (minSize > right + 1 - left) {
                    res = s.substring(left, right + 1);
                    minSize = right + 1 - left;
                }
                char c = s.charAt(left);
                if (subMap.containsKey(c)) {
                    subMap.put(c, subMap.get(c) - 1);
                }
                left++;
            } else {
                right++;
                if (right > s.length() - 1) {
                    break;
                }
                char c = s.charAt(right);
                if (subMap.containsKey(c)) {
                    subMap.put(c, subMap.get(c) + 1);
                }
            }

        }


        return res;
    }

    private boolean check() {
        for (Character c : subMap.keySet()) {
            if (subMap.get(c) < recordMap.get(c)){
                return false;
            }
        }
        return true;
    }
}