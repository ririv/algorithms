package leetcode.p206;

// 递归法，详解有点绕，见官方题解
// 字节要求两种都写出

import leetcode.definitions.singlyLinkedList.ListNode;

// 需要注意的是 n_1 的下一个节点必须指向 ∅。如果忽略了这一点，链表中可能会产生环。
class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;


        return temp;
    }
}
