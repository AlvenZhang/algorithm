package hash;

import sun.font.TrueTypeFont;

import java.util.HashSet;

public class Solution202 {


    public static void main(String[] args) {
        boolean happy = new Solution202().isHappy(2);
        System.out.println(happy);
    }


    public boolean isHappy(int n) {

        // 求平方和
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        while (n!=1){
            n = getNextNumber(n);
            if (set.contains(n)){
                return false;
            }
            set.add(n);
        }
        return true;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            n /= 10;
            res += temp * temp;
        }
        return res;
    }
}
