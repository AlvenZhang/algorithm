package backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution131 {

    public static void main(String[] args) {
//        boolean aba = new Solution131().judge("aaaa");
//        System.out.println(aba);
        List<List<String>> partition = new Solution131().partition("aab");
        System.out.println(partition.toString());
    }

    public List<List<String>> partition(String s) {
        ArrayList<List<String>> ans = new ArrayList<>();
        backTracking(ans, new LinkedList<>(), s, 0);
        return ans;
    }

    private void backTracking(List<List<String>> ans, LinkedList<String> ansSub, String s, int startIndex) {
        // 结束条件
        if (startIndex >= s.length()) {
            ans.add(new ArrayList<>(ansSub));
            return;
        }

        for (int i = startIndex + 1; i <= s.length(); i++) {
            String substring = s.substring(startIndex, i);
            if (isP(substring)) {
                ansSub.add(substring);
                backTracking(ans, ansSub, s,  i);
            } else {
                continue;
            }
            // 恢复
            ansSub.removeLast();
        }
    }

    private boolean isP(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
