package string;

import greedy.Solution455;
import jdk.nashorn.internal.ir.Flags;

public class Solution459 {

    public static void main(String[] args) {
        System.out.println(new Solution459().repeatedSubstringPattern("aabaaba"));
    }

    public boolean repeatedSubstringPattern(String s) {

        for (int i = 1; i <= s.length() / 2; i++) {
            boolean flag = true;
            if (s.length() % i != 0) {
                return false;
            }
            for (int i1 = i; i1 + i <= s.length(); i1 += i) {
                if (!compare(s.substring(i1, i1 + i), s.substring(0, i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    private boolean compare(String a, String b) {
        return a.equals(b);
    }
}
