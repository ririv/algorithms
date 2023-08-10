package leetcode.p19;

import leetcode.definitions.singlyLinkedList.ListNode;

public class Test {
    public static void p19() {
        Solution solution = new Solution();

        int[] values = {1, 2, 3, 4, 5};

        ListNode head;
        ListNode pre;

        ListNode listNode = new ListNode(values[0]);
        head = listNode;
        pre = listNode;

        for (int i=1; i < values.length; i++) {
            listNode = new ListNode(values[i]);
            pre.next = listNode;
            pre = listNode;
        }

        ListNode ans = solution.removeNthFromEnd(head,2);
        System.out.println(ans);
    }
}
