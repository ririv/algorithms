package leetcode.p24;

import leetcode.definitions.singlyLinkedList.ListNode;

// MINE，迭代
// 不难，但有点绕
// 本题官方有递归解法，但空姐复杂度为O(n)，而本方法空间复杂度为O(1)，官方的迭代法有创建头节点，本方法没有。
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre=null;
        ListNode current1;
        ListNode current2;
        ListNode res = head.next;

        while (head!= null) {
            if (head.next==null) break;

            current1 = head;
            current2 = head.next;

            if(pre!=null) pre.next = current2;

            current1.next = current2.next;
            current2.next = current1;

            pre = current1;
            head = current1.next;
        }

        return res;
    }
}