package twopointer;

import java.util.Scanner;

public class Solution027 {

    public static void main(String[] args) {
        System.out.println(new Solution027().removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i-k] = nums[i];
            if (nums[i] == val){
                k++;
            }
        }

        return nums.length-k;
    }
}
