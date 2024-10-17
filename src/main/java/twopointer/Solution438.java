package twopointer;

import jdk.nashorn.internal.runtime.FindProperty;

import java.util.*;

public class Solution438 {


    public static void main(String[] args) {
        List<Integer> anagrams = new Solution438().findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams.toString());
    }

    /**
     * 滑动窗口解决
     * 窗口大小为p.length
     * 将p放入Map中保存字符与个数信息
     * 判断窗口中是否有足够字符，如果有就记录下来（记录left）
     * <p>
     * 超出时间限制，应该是因为check，导致最坏时间复杂度为O(mn)
     *
     * @param s
     * @param p
     * @return
     */
    HashMap<Character, Integer> mapWindow = new HashMap<>();
    HashMap<Character, Integer> mapP = new HashMap<>();

    public List<Integer> findAnagrams(String s, String p) {

        ArrayList<Integer> res = new ArrayList<>();
        if (s.length() < p.length()){
            return res;
        }
        for (int i = 0; i < p.length(); i++) {
            mapP.put(p.charAt(i), mapP.getOrDefault(p.charAt(i), 0) + 1);
            mapWindow.put(s.charAt(i), mapWindow.getOrDefault(s.charAt(i), 0)+1);
        }

        int left = 0;
        int right = left + p.length();

        if (check()){
            res.add(left);
        }

        while (right < s.length()) {
            mapWindow.put(s.charAt(left), mapWindow.getOrDefault(s.charAt(left), 0) - 1);
            mapWindow.put(s.charAt(right), mapWindow.getOrDefault(s.charAt(right), 0) + 1);
            left++;
            right++;
            if (check()) {
                res.add(left);
            }
        }

        return res;
    }

    private boolean check() {
        for (Character c : mapP.keySet()) {
            Integer i = mapP.get(c);
            if (!Objects.equals(mapWindow.get(c), i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用数组记录，并且判断窗口内的字符是否是异位词
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();

        if (s.length() < p.length()){
            return res;
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }

        int left = 0;
        int right = left + p.length();

        while (right < s.length()) {
            sCount[s.charAt(left++) - 'a']--;
            sCount[s.charAt(right) - 'a']++;
            right++;
            if (Arrays.equals(sCount, pCount)) {
                res.add(left);
            }
        }

        return res;
    }
}
