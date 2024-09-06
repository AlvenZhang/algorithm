package string;

import java.util.Scanner;

public class Solution_K55 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        scanner.close();
        System.out.println(s.substring(s.length()-n)+s.substring(0,s.length()-n));
    }
}
