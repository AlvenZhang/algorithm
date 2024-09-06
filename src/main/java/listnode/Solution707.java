package listnode;

public class Solution707 {


    /**
     * 设计一个链表，实现链表的功能
     * @param args
     */
    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(4);  // 2
        myLinkedList.get(1);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(5);
        myLinkedList.deleteAtIndex(3);
        myLinkedList.addAtHead(7);
        myLinkedList.get(3);
        myLinkedList.get(3);
        myLinkedList.get(3);
        myLinkedList.addAtHead(1);
        myLinkedList.deleteAtIndex(4);

    }
}


class MyLinkedList {
    // 需要头节点
    private ListNode node = null;
    int length = 0;

    public MyLinkedList() {
        this.node = new ListNode();
        this.length = 0;
    }

    public int get(int index) {
        if (index >= this.length || index < 0){
            return -1;
        }
        ListNode pointer = this.node.next;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        return pointer.val;
    }

    public void addAtHead(int val) {
        ListNode listNode = new ListNode();
        listNode.val = val;
        listNode.next = this.node.next;
        this.node.next = listNode;
        this.length++;
    }

    public void addAtTail(int val) {
        ListNode pointer = this.node;
        while (pointer != null && pointer.next != null){
            pointer = pointer.next;
        }
        ListNode listNode = new ListNode();
        listNode.val = val;
        listNode.next = null;
        pointer.next = listNode;
        this.length++;
    }

    public void addAtIndex(int index, int val) {
        if (index >= 0 && index <= this.length){
            ListNode listNode = new ListNode();
            listNode.val = val;
            ListNode pointer = this.node;
            for (int i = 0; i < index; i++) {
                pointer = pointer.next;
            }
            listNode.next = pointer.next;
            pointer.next = listNode;
            this.length++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index < this.length){
            ListNode pointer = this.node;
            for (int i = 0; i < index; i++) {
                pointer = pointer.next;
            }
            pointer.next = pointer.next.next;
            this.length--;
        }
    }
}