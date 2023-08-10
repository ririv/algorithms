package leetcode.p25;

import leetcode.definitions.singlyLinkedList.ListNode;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while (true) {
            ListNode end = pre;
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) return dummy.next;
            }
            ListNode next = end.next;
            end.next = null;
            end = pre.next;
            head = reverse(pre.next);
            pre.next = head;
            end.next = next;
            pre = end;
        }
    }

    ListNode reverse(ListNode head) {
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
