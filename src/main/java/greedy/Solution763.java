package greedy;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {

    public static void main(String[] args) {
        System.out.println(new Solution763().partitionLabels("ababcbacadefegdehijhklij"));
    }

    /**
     * 首先将字符串中字母放入哈希表中，并记录最后出现位置
     * 遍历的时候不断更新字母的最后出现位置，遍历到最后位置则表示一个区间结束
     * 重新更新最后位置
     *
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        int[] hash = new int[27];
        // 记录字母最后位置
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i + 1;
        }
        // 记录区间长度
        ArrayList<Integer> res = new ArrayList<>();
        // 区间最后位置
        int pos = 0;
        // 上一个区间的最后位置
        int lastPos = 0;
        // 当前区间的内容
//        List<Character> array = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
//            array.add(s.charAt(i));
            pos = Math.max(hash[s.charAt(i) - 'a'], pos);

            // 遍历到区间结束位置
            if (pos == i + 1) {
//                array.clear();
                res.add(pos - lastPos);
                lastPos = pos;
            }
        }

        return res;
    }
}
