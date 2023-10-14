# 排序找左右指针
from typing import List


class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:

        # 边界情况
        def is_sorted(nums):
            for i in range(1, len(nums)):
                if nums[i - 1] > nums[i]:
                    return False
            return True

        if is_sorted(nums):
            return 0

        sorted_nums = sorted(nums)
        L,R = 0, len(nums)-1
        while nums[L] == sorted_nums[L]:
            L += 1
        while nums[R] == sorted_nums[R]:
            R -= 1
        return R-L+1

