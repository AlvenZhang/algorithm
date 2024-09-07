package twopointer;

public class Solution344 {

    public static void main(String[] args) {
        char[] ch = new char[]{'h','e','l','l','o'};
        new Solution344().reverseString(ch);
        for (char c : ch) {
            System.out.print(c);
        }
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }
    }
}
