package greedy;

public class Solution738 {

    public static void main(String[] args) {
        System.out.println(new Solution738().monotoneIncreasingDigits(1234));
    }


    /**
     * 从后向前遍历n，比较两个位置数字的大小
     *
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {

        char[] charArray = String.valueOf(n).toCharArray();
        int pos = charArray.length;
        for (int i = charArray.length - 1; i > 0; i--) {
            if (charArray[i - 1] > charArray[i]) {
                charArray[i - 1]--;
                pos = i;
            }
        }
        for (int i = pos; i < charArray.length; i++) {
            charArray[i] = '9';
        }

        return Integer.parseInt(String.valueOf(charArray));
    }
}
