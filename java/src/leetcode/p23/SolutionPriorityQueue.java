package leetcode.p23;

import leetcode.definitions.singlyLinkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

// 字节面试可能会要求使用优先队列，而不可以使用分治法
// O(kn×logk) O(k)
// Suggested
public class SolutionPriorityQueue {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists==null || lists.length==0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node : lists) {
            if (node != null) queue.offer(node);
        }

        ListNode  dummyHead = new ListNode();
        ListNode p = dummyHead;

        while (!queue.isEmpty()){
            ListNode current = queue.poll();
            if(current.next!=null){
                queue.offer(current.next);
            }
            p.next = current;
            p = p.next;
        }
        return dummyHead.next;
    }
}
