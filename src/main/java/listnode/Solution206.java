package listnode;

public class Solution206 {

    /**
     *  反转一个单链表
     * @param args
     */
    public static void main(String[] args) {
        ListNode list = Solution203.createList();
        ListNode listNode = new Solution206().reverseList(list);
        System.out.println(listNode);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pointer1 = head;
        ListNode pointer2 = head.next;
        ListNode temp = null;
        while (pointer2 != null){
            pointer1.next = temp;
            temp = pointer1;
            pointer1 = pointer2;
            pointer2 = pointer2.next;
        }
        pointer1.next = temp;

        return pointer1;
    }
}
