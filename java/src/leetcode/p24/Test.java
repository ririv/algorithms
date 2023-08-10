package leetcode.p24;

import leetcode.definitions.singlyLinkedList.ListNode;

public class Test {
    public static void main(String[] args) {
        ListNode list1 = ListNode.createListByVals(new int[]{1,2,3,4});

        Solution solution = new Solution();
        var ans = solution.swapPairs(list1);
        System.out.println(ans);
    }
}
