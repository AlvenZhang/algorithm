public class JDTest2 {

    // 找出第二大数
    public static void main(String[] args) {
        System.out.println(JDTest2.find(new int[]{1,2,3,4,5,6,7,8}));
    }

    public static int find(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int[] res = new int[2];
        res[0] = Integer.MIN_VALUE;
        res[1] = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num>res[0]){
                res[1] = res[0];
                res[0] = num;
            }
        }
        return res[1];
    }

}
