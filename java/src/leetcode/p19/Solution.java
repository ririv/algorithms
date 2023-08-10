package leetcode.p19;


import leetcode.definitions.singlyLinkedList.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// 简单
// MINE 和官方题解"计算链表长度"思路一致
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        p = head;

        if (len == 1) {
            return null;
        }

        if (len > 1 && len == n) {
            p = head.next;
            head.next = null;
            return p;
        }

        int m = len - n;
        ListNode pre = p;
        while (m > 0) {
            pre = p;
            p = p.next;
            m--;
        }
        pre.next = p.next;
        return head;
    }
}

