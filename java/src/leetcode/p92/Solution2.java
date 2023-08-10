package leetcode.p92;

import leetcode.definitions.singlyLinkedList.ListNode;

//头插法
//有点绕，可能把自己绕晕，不推荐
class Solution2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyhead = new ListNode(); //头插法需要在第一个节点之前设置一个头节点，已保证找处理第一个节点时的一致性
        ListNode preLeft = dummyhead;
        for (int i = 0; i < left - 1; i++) { // preLeft指向left前一个节点
            preLeft = preLeft.next;
        }
        ListNode current = preLeft.next;
        ListNode next; //先不初始化，因为current可能为null

        //注意current不需要重新指向的，看图可知道，在完成一次重塑后，current指向的节点位置正好改变到了下一个位置（最后它一定是在尾节点的位置）
        for (int i = 0; i < right - left; i++) {
            next = current.next;
            current.next = next.next;
            next.next = preLeft.next; //这里不能指向current，在第一次循环中，这个指向是对的，但在后面的循环中，current的位置其实是在更后面的
            preLeft.next = next;

        }

        return dummyhead.next;
    }
}