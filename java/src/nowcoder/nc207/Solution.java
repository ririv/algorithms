package nowcoder.nc207;

import nowcoder.definitions.ListNode;

//https://www.nowcoder.com/practice/3a188e9c06ce4844b031713b82784a2a
//此题虽然麻烦，但其实只是几个简单题的组合题

//1. 按奇偶位置拆分链表
//2. 反转偶链表
//3. 合并两个有序链表
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode sortLinkedList(ListNode head) {
        // write code here
        ListNode oddHead = head;
        ListNode evenHead = splitEvenHead(head);
        evenHead = reverseList(evenHead);

        return mergeTwoList(oddHead,evenHead);

    }

    ListNode splitEvenHead(ListNode head) {
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next; //此时odd已经指向下一个了，因此与上一条语句的顺序不能颠倒
            even = even.next;
        }
        // 此时odd是倒数第二个节点，odd.next指向最后一个节点，所以置null
        // even是最后一个节点，因此even.next 就是null
        odd.next = null;

        return evenHead;
    }

    ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1!=null) p.next = l1;
        else p.next = l2;

        return dummyHead.next;
    }
}
