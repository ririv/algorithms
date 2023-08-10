package leetcode.p206;

import leetcode.definitions.singlyLinkedList.ListNode;

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = pre; //Note，要修改的next指针只有这一个，不要多写，后面两行语句都是前进
            pre = current;
            current = next;
        }

        // 此时current指向了一个尾节点的next，是一个空指针，pre才是尾节点，因此返回pre。
        return pre;

    }
}