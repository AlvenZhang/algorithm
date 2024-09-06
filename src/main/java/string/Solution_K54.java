package string;

import sun.applet.Main;

import java.util.Scanner;

public class Solution_K54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String solution = new Solution_K54().solution(s);
        System.out.println(solution);
    }

    String solution(String s){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isNumber(s.charAt(i))){
                stringBuilder.append("number");
            }else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    private boolean isNumber(char ch){
        if (ch >= '0' && ch <= '9'){
            return true;
        }
        return false;
    }
}
