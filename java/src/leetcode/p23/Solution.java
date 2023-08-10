package leetcode.p23;

import leetcode.definitions.singlyLinkedList.ListNode;


// MINE k指针法
// https://leetcode.cn/problems/merge-k-sorted-lists/solution/4-chong-fang-fa-xiang-jie-bi-xu-miao-dong-by-sweet/
// TODO, O(NK) 效率不高，可以再优化为 O(NlogK)，如分治法，小根堆
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode mergedList = new ListNode();
        ListNode head = mergedList;

        while (true) {
            int min_i = -1;

            // flag用于判断数组是否为全null
            // 使用flag的好处是，无需在前面判断lists是否为[[],[]]形式的特例
            boolean flag = false;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) continue;
                else if (!flag) {
                    min_i = i;
                    flag = true;
                }
                // min_i= 0 可能指向的空指针，因此，此情况时，我们给min_i指向找到第一个非空指针
                // lists[min_i] == null 只会在找到第一个非空指针时触发
                if (lists[i].val < lists[min_i].val) {
                    min_i = i;
                }
            }

            // 如果flag没更新，说明list所有元素均已经指向null，merge完毕，break
            // 注意此break需要放在前面，因为flag为false的时候，min_i = -1，后面的语句会发生越界错误。
            if (!flag) {
                break;
            }

            mergedList.next = lists[min_i];
            mergedList = mergedList.next;
            lists[min_i] = lists[min_i].next;


        }
        return head.next;
    }
}