package leetcode.p160;

import leetcode.definitions.singlyLinkedList.ListNode;

// 双指针
// 若相交，链表A： a+c, 链表B : b+c.
// 指针移动了a+c+b次，指针移动了b+c+a次，相遇且同时到达相交节点
// 若不相交，a+b = b+a 。因此相遇处是NULL
// O(m+n) O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) return null;   // 可以不要
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1= p1 == null ? headB : p1.next;
            p2= p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
