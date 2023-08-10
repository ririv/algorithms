package leetcode.p21;

import leetcode.definitions.singlyLinkedList.ListNode;

// MINE
// 迭代，原地操作
// 官方第二种解法：迭代 思路一致
// 不同的是官方迭代题解在第一个节点前新建了一个头节点，以达到以一致的方式在循环中处理第一个节点（数据结构书中有讲）
// 最后return head.next，即第一节点为头节点的下一个节点
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummyHead = new ListNode();
        ListNode p = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1 != null) p.next = list1;
        else p.next = list2;

        return dummyHead.next;
    }
}