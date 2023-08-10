package leetcode.p21;

import leetcode.definitions.singlyLinkedList.ListNode;

public class Test {

    public static void main(String[] args) {
        ListNode list1 = ListNode.createListByVals(new int[]{1,2,4});
        ListNode list2 = ListNode.createListByVals(new int[]{1,3,4});

        Solution solution = new Solution();
        var ans = solution.mergeTwoLists(list1,list2);
        System.out.println(ans);
    }
}
