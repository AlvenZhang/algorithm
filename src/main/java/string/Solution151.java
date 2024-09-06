package string;

public class Solution151 {

    public static void main(String[] args) {
        String s = new Solution151().reverseWords("a good   example");
        System.out.println(s);
    }

    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length-1; i >=0; i--) {
            String trim = split[i].trim();
            stringBuilder.append(trim);
            if (!trim.isEmpty()){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }
}
