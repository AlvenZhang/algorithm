package com.algorithm.leetcode_100days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution049 {

    public static void main(String[] args) {
        List<List<String>> lists = new Solution049().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        System.out.println(lists.toString());
    }

    /**
     *
     * 题解：可以直接使用Hash建立映射关系，而不需要使用两个List
     *
     * 使用List存储某组异位词的字母
     * 使用List存储ans
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 存储字母
        ArrayList<String> words = new ArrayList<>();
        // ans
        ArrayList<List<String>> lists = new ArrayList<>();
        // 遍历strs，
        for (String str : strs) {
            String[] split = str.split("");
            Arrays.sort(split);
            String str1 = String.join("", split);
            if (words.contains(str1)) {
                lists.get(words.indexOf(str1)).add(str);
            }else {
                words.add(str1);
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                lists.add(list);
            }
        }
        return lists;
    }
}
