package leetcode.p92;

import leetcode.definitions.singlyLinkedList.ListNode;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode preLeft = dummyHead;
        for (int i = 0; i < left - 1; i++) { //preLeft指向left前一个节点，因此-1
            preLeft = preLeft.next;
        }

        ListNode leftNode = preLeft.next;
        ListNode rightNode = leftNode; // 指向left
        for (int i = 0; i < right - left; i++) { //rightNode指向right节点
            rightNode = rightNode.next;
        }
        ListNode rightNext = rightNode.next;

        //Note  切断
        preLeft.next = null;
        rightNode.next = null;

        reverseList(leftNode);

        preLeft.next = rightNode; //rightNode 必定是子链表的第一个节点
        leftNode.next = rightNext; //LeftNode 必定是子链表的最后一个节点

        return dummyHead.next;
    }

    ListNode reverseList(ListNode head) {
        if(head.next ==null) return head;

        ListNode pre = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre.next;
    }

    //此方法无需断开链表，返回的是头节点（index 0）和尾节点（index 1）
    public ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode p = head;
        while (pre != tail) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }

}