
from typing import Optional

from leetcode.definitions.singly_linked_list import ListNode


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    # O(n) O(1)
    # 快慢指针找到一半，头插法翻转前半段，再遍历
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        pass



# 提供个最容易想到的方法，记得判断长度奇偶性
class Solution2:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        nums = []
        while head:
            nums.append(head.val)
            head = head.next
        return nums == nums[::-1]  # python 判断回文
