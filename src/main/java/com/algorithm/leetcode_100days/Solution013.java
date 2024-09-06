package com.algorithm.leetcode_100days;

import java.util.HashMap;
import java.util.Map;

public class Solution013 {


    /**
     * 罗⻢数字转整数
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution013 solution013 = new Solution013();
        int i = solution013.romanToInt2("MCMXCIV");
        System.out.println(i);
    }


    /**
     * 切分整个s，先将两个字符进行判断，未匹配则将一个字符进行判断
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int sumV = 0;
        HashMap<String, Integer> map = new HashMap<>();
        this.initMap(map);

        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                sumV += map.get(s.substring(i, i + 2));
                i++;
            } else {
                sumV += map.get(s.substring(i, i + 1));
            }
        }
        return sumV;
    }

    private void initMap(Map<String, Integer> map) {
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

    }


    /**
     *
     * @param s
     * @return
     */
    public int romanToInt2(String s) {
        int sumV = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && match(s.charAt(i)) < match(s.charAt(i + 1))) {
                sumV -= match(s.charAt(i));
            }else {
                sumV += match(s.charAt(i));
            }
        }
        return sumV;
    }

    private int match(char ch) {
        if (ch == 'I') return 1;
        else if (ch == 'V') return 5;
        else if (ch == 'X') return 10;
        else if (ch == 'L') return 50;
        else if (ch == 'C') return 100;
        else if (ch == 'D') return 500;
        else if (ch == 'M') return 1000;
        else return 0;
    }
}
