package hash;

import java.lang.management.ManagementFactory;
import java.util.HashMap;

public class Solution383 {

    /**
     * 使用Map记录magazine中字符出现的次数
     * 然后遍历ransomNote，同时减少magazine中字符出现次数
     *
     * @param args
     */
    public static void main(String[] args) {
        boolean b = new Solution383().canConstruct("aa", "aab");
        System.out.println(b);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        // 记录map
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (!map.containsKey(ransomNote.charAt(i)) || map.get(ransomNote.charAt(i)) <= 0) {
                return false;
            } else {
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
            }
        }
        return true;
    }

    /**
     * 使用数组的写法，key的出现较为密集。使用map反而消耗的空间更大
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] array = new int[26];
        // 记录map
        for (int i = 0; i < magazine.length(); i++) {
            array[magazine.charAt(i)-'a'] = array[magazine.charAt(i)-'a'] + 1;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (array[ransomNote.charAt(i)]<=0){
                return false;
            }else {
                array[ransomNote.charAt(i)-'a'] = array[ransomNote.charAt(i)-'a'] - 1;
            }
        }

        return true;
    }
}
