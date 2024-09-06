package com.algorithm.leetcode_100days;

import javax.swing.plaf.SliderUI;
import java.util.ArrayList;
import java.util.List;

public class Solution038 {

    /**
     * 外观数列
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution038 solution038 = new Solution038();
//        List<String> split = solution038.split("111222113322");
//        System.out.println(split.toString());
        String s = solution038.countAndSay2(5);
        System.out.println(s);
    }

    /**
     * 没有规律，没直接用dp
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String lastNumber = "1";
        if (n == 1) {
            return lastNumber;
        }

        for (int i = 2; i <= n; i++) {
            // 拆分字符串
            List<String> split = this.split(lastNumber);

            // 逐个字串进行描述，然后拼接作为lastNumber
            StringBuilder sb = new StringBuilder();
            for (String s : split) {
                int length = s.length();
                int content = s.charAt(0) - '0';
                sb.append(length);
                sb.append(content);
            }
            lastNumber = sb.toString();
        }
        return lastNumber;
    }

    // 拆分字符串
    private List<String> split(String str) {
        List<String> res = new ArrayList<>();

        int i = 1;
        char last = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(last);
        while (i < str.length()) {
            if (str.charAt(i) == last) {
                sb.append(str.charAt(i));
            } else {
                res.add(sb.toString());
                sb = new StringBuilder();
                sb.append(str.charAt(i));
            }
            last = str.charAt(i);
            i++;
        }
        res.add(sb.toString());
        return res;
    }


    /**
     * 第一种方法是将字符串先拆分，然后再遍历字串获取结果
     * <p>
     * 这里也可以直接对字符串进行遍历
     *
     * @param n
     * @return
     */
    public String countAndSay2(int n) {

        String str = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            // 遍历str
            int head = 0, tail = 1;
            for (; tail < str.length(); tail++) {

                if (str.charAt(head) != str.charAt(tail)) {
                    // 记录长度
                    int length = tail - head;
                    // 记录字符
                    int ch = str.charAt(head) - '0';
                    // 保存
                    sb.append(length);
                    sb.append(ch);

                    // 更新head
                    head = tail;
                }
            }
            int length = tail - head;
            // 记录字符
            int ch = str.charAt(head) - '0';
            // 保存
            sb.append(length);
            sb.append(ch);
            str = sb.toString();
        }

        return str;
    }
}
