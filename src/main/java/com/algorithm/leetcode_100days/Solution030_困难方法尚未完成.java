package com.algorithm.leetcode_100days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution030_困难方法尚未完成 {


    /**
     * 串联所有单词的子串
     * 困难
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution030_困难方法尚未完成 solution030 = new Solution030_困难方法尚未完成();
        List<Integer> substring = solution030.findSubstring3("barfoothefoobarman", new String[]{"foo", "bar"});
        System.out.println(substring.toString());
    }


    /**
     * 1. 获得字串长度
     * 2. 通过字串长度不断匹配字串，直至所有子串被匹配完
     * 3. 如果出现中断则继续开启下一个索引
     * <p>
     * 匹配失败情况：子串无法匹配、所有子串匹配完成之前有子串重复匹配、
     * <p>
     * 因为字符串数组中可能会出现重复字符串，所以无法直接用hashmap记录字符串是否被匹配过
     * 可以使用map记录字串在数组中出现的次数，然后匹配到就减一当所有字串出现次数为0时，表示匹配成功
     * <p>
     * 结果：倒数第二个实例超出时间限制
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        // 定义返回数组
        List<Integer> res = new ArrayList<>();
        // 设置子串map，使用integer表示字串被提及的次数
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        int len_sub = words[0].length();

        for (int i = 0; i <= s.length() - len_sub * words.length; i++) {
            Map<String, Integer> temp_map = new HashMap<>(map);
            for (int j = i; j <= s.length() - len_sub; j += len_sub) {
                String temp_sub = s.substring(j, j + len_sub);
                if (!temp_map.containsKey(temp_sub)) {
                    break;
                }
                if (temp_map.get(temp_sub) < 1) {
                    break;
                }
                temp_map.replace(temp_sub, temp_map.get(temp_sub) - 1);
                // 检查map中是否全部被串联，如果是，则保存起始点并跳出内层循环
                int flag = 1;
                for (String string : temp_map.keySet()) {
                    if (!(temp_map.get(string) == 0)) {
                        flag = -1;
                        break;
                    }
                }
                if (flag == 1) {
                    res.add(i);
                }
            }
        }

        return res;
    }


    /**
     * 使用滑动窗口，窗口大小为len_sub * words.length
     * 使用differMap记录words中的单词，以及出现的次数
     * 窗口中的字符串可以按照len_sub分块，如果能跟differMap中相匹配，则是一个串联字串；否则滑动窗口
     * <p>
     * 使用了滑动窗口，但是运行依然很慢，只能超过5%
     * 分析发现每次窗口移动之后都需要重新检查窗口内每个字串是否出现过。造成了大量的时间浪费
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring2(String s, String[] words) {

        List<Integer> res = new ArrayList<>();
        int sub_len = words[0].length();

        // 创建differMap
        Map<String, Integer> differMap = new HashMap<>();
        for (String word : words) {
            differMap.put(word, differMap.getOrDefault(word, 1));
        }

        // i是窗口开始的位置
        for (int k = 0; k < sub_len; k++) {
            for (int i = k; i <= s.length() - sub_len * words.length; i += sub_len) {
                Map<String, Integer> temp_map = new HashMap<>(differMap);
                // 检查窗口中的字串是否符合要求
                // 窗口范围「i, sub_len * words.length）
                for (int j = i; j < i + sub_len * words.length; j += sub_len) {
                    String sub_string = s.substring(j, j + sub_len);
                    if (temp_map.containsKey(sub_string) && temp_map.get(sub_string) > 0) {
                        temp_map.put(sub_string, temp_map.get(sub_string) - 1);
                        // 如果都为0，则是串联字串
                        int flag = 1;
                        for (String string : temp_map.keySet()) {
                            if (temp_map.get(string) != 0) {
                                flag = -1;
                                break;
                            }
                        }
                        if (flag == 1) {
                            res.add(i);
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return res;
    }

    /**
     * 更换检查滑动窗口内字串的方法
     * 新滑入窗口的单词加到differ中，划出的单词从differ中删除
     * 一旦differ为空，说明当前字串为串联，与words中的单词相同
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int sub_len = words[0].length();
        int num = words.length;

        for (int i = 0; i < sub_len; i++) {

            // 按照当前窗口的子串，初始化differ
            Map<String, Integer> differ = new HashMap<>();
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (int j = i; j < i + sub_len * num; j += sub_len) {
                String sub_string = s.substring(j, j + sub_len);
                differ.put(sub_string, differ.getOrDefault(sub_string, 0) - 1);
                if (differ.get(sub_string) == 0) {
                    differ.remove(sub_string);
                }
            }

            if (differ.isEmpty()) {
                res.add(i);
            }

            // 滑动窗口
            for (int j = i + sub_len; j < s.length() - num * sub_len; j += sub_len) {
                // 新滑入窗口的单词
                String sub_string = s.substring(j + num * sub_len, j + (num + 1) * sub_len);
                differ.put(sub_string, differ.getOrDefault(sub_string, 0) + 1);

                // 滑出窗口的单词
                sub_string = s.substring(j, (j + 1) * sub_len);
                differ.put(sub_string, differ.getOrDefault(sub_string, 0) - 1);
                if (differ.get(sub_string) == 0) {
                    differ.remove(sub_string);
                }

                if (differ.isEmpty()) {
                    res.add(j);
                }
            }
        }
        return res;
    }
}
