package leetcode.p142;

import leetcode.definitions.singlyLinkedList.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast= head;
        while (true){
            if(fast==null || fast.next==null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        while (head!=slow){
            head = head.next;
            slow = slow.next;
        }
        return head;

    }
}