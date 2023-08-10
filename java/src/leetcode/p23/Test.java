package leetcode.p23;

import leetcode.definitions.singlyLinkedList.ListNode;

public class Test {
    public static void main(String[] args) {
        ListNode list1 = ListNode.createListByVals(new int[]{1,4,5});
        ListNode list2 = ListNode.createListByVals(new int[]{1,3,4});
        ListNode list3 = ListNode.createListByVals(new int[]{2,6});

        Solution solution = new Solution();
        var ans = solution.mergeKLists(new ListNode[]{list1,list2,list3});
        System.out.println(ans);
    }
}
