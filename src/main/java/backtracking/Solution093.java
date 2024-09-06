package backtracking;

import com.sun.org.apache.xpath.internal.operations.And;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution093 {

    /**
     * 本质就是划分字符串
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> strings = new Solution093().restoreIpAddresses("99999999999999999999");
        System.out.println(strings);
    }

    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> ans = new ArrayList<>();
        if (s.length() > 12) return ans;
        backTracking(ans, new LinkedList<>(), 1, 0, s);
        return ans;
    }

    private void backTracking(List<String> ans, LinkedList<String> ansSub, int k, int startIndex, String s) {
        // 终止条件
        if (k > 4) {
            if (startIndex >= s.length()) {
                ans.add(String.join(".", ansSub));
            }
            return;
        }

        for (int i = startIndex + 1; i <= s.length(); i++) {
            String substring = s.substring(startIndex, i);
            if (judge(substring)) {
                ansSub.add(substring);
                backTracking(ans, ansSub, k + 1, i, s);
                ansSub.removeLast();
            }
        }
    }

    // 判断输入的字符串是否是合法的IP数字
    private boolean judge(String string) {
        // 只有开头是0直接返回false
        if (string.length() > 3 || string.length() > 1 && string.charAt(0) == '0') {
            return false;
        }
        int l = Integer.parseInt(string);
        return l >= 0 && l <= 255;
    }
}
