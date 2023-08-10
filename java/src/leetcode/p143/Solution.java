package leetcode.p143;

import leetcode.definitions.singlyLinkedList.ListNode;

//O(n), O(1)
class Solution {
    public void reorderList(ListNode head) {
        ListNode middle = findMiddleNode(head);
        ListNode l2 = reverseList(middle.next); //Note middle.next 才是下半段
        middle.next = null; // Note 将两个链表断开，防止影响
        mergeList(head, l2);
    }


    void mergeList(ListNode l1, ListNode l2) {
        ListNode temp1; // 用于指向下一个节点next
        ListNode temp2;
        while (l1 != null && l2 != null) {
            temp1 = l1.next;
            temp2 = l2.next;

            l1.next = l2;
            l1 = temp1;

            l2.next = l1;
            l2 = temp2;
        }
    }


    ListNode findMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) { //Note: 判两次 fast 的next，slow没必要判
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}