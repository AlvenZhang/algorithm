package listnode;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution019 {
    /**
     * 删除倒数第n个节点
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{1,2};
        ListNode list = Solution203.createList(array);
        ListNode listNode = new Solution019().removeNthFromEnd(list, 2);
        System.out.println(listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 遍历得到list长度
        ListNode pointer = head;
        int k = 0;
        while (pointer!=null){
            k++;
            pointer = pointer.next;
        }
        if (k == 1){
            return null;
        }

        if (k < n){
            return head;
        }

        // 删除正数第length-n+1个节点，也就是遍历到length-n
        pointer = new ListNode();
        ListNode pointer2 = pointer;
        pointer2.next = head;
        for (int i = 0; i < k-n; i++) {
            pointer2 = pointer2.next;
        }
        pointer2.next = pointer2.next.next;

        return pointer.next;
    }
}
