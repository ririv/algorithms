# 回溯，穷举所有情况
from typing import List


# 本题pythondfs，超时了，要用dp
class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        res = 0


        def backtrack(nums, target, index, sum):
            nonlocal res
            if index == len(nums):  #index超出边界，终止，此时计算sum是否满足要求
                if sum == target:
                    res+=1
            else:
                backtrack(nums, target, index+1, sum+nums[index])
                backtrack(nums, target, index+1, sum-nums[index])

        backtrack(nums, target, 0, 0)
        return res