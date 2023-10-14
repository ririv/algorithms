package leetcode.p148;

// 归并排序，递归
// 找到中点，分别排序，再合并

import leetcode.definitions.singlyLinkedList.ListNode;

class Solution {
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    ListNode sort(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null; //切断
            return head;
        }
        //找到中点
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode left = sort(head, mid);
        ListNode right = sort(mid, tail);
        return merge(left, right);
    }

    // 合并两个有序子链表
    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode p = list1, q = list2, r = dummyHead;

        while (p!=null && q!=null){
            if (p.val <= q.val){
                r.next = p;
                p = p.next;
            }
            else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        if(p!=null) r.next = p;
        else  r.next = q;
        return dummyHead.next;
    }
}
