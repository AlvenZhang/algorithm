package listnode;

public class Solution142 {


    /**
     * 环形链表，找到环形链表开始入环的第一个节点
     * 判断链表是否有环：慢指针一次走一个节点，快指针一次走两个节点。如果链表有环，则相当于快指针在一步一步接近快指针
     * x表示从头节点到环入口的距离；y表示入口节点与fast、slow指针相遇的距离；z表示相遇节点到入口节点的距离
     * 相遇时，slow走过节点数x+y，fast走过节点数x+y+n(y+z)
     * (x+y)*2 = x+y+n(y+z)
     * x+y = n(y+z)
     * x = n(y+z)-y = (n-1)(y+z)+z
     * @param args
     */
    public static void main(String[] args) {
        Solution142 solution142 = new Solution142();
        ListNode listNode = solution142.detectCycle(null);
        System.out.println(listNode);
    }


    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next != null){    // 因为fast走的快，所以只需要保证fast不为null，不需要判断slow。因为fast一次走两步，所以需要判断fast.next
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                ListNode index1 = head;
                ListNode index2 = fast;
                while (index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
