package hash;

import java.util.HashMap;

public class Solution242 {

    public static void main(String[] args) {
        boolean anagram = new Solution242().isAnagram2("", "");
        System.out.println(anagram);
    }


    public boolean isAnagram(String s, String t) {

        // 使用hashMap记录每个字符出现的次数
        HashMap<Character, Integer> cache = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (cache.containsKey(c)) {
                cache.put(c, cache.get(c) + 1);
            } else {
                cache.put(c, 1);
            }
        }

        // 遍历cache，减去t出现的字符
        for (char c : t.toCharArray()) {
            if (cache.containsKey(c)) {
                if (cache.get(c) - 1 <= 0) {
                    cache.remove(c);
                } else {
                    cache.put(c, cache.get(c) - 1);
                }
            } else {
                return false;
            }
        }

        return cache.isEmpty();
    }

    public boolean isAnagram2(String s, String t) {
        int[] cache = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cache[s.charAt(i)-97]++;
        }
        for (int i = 0; i < t.length(); i++) {
            cache[t.charAt(i)-97]--;
        }

        for (int num : cache) {
            if (num!=0){
                return false;
            }
        }
        return true;
    }
}
