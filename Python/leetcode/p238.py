# 左右乘积列表
from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        length = len(nums)
        L, R, ans = [0] * length, [0] * length, [0] * length
        # L[i]
        L[0] = 1  # 左侧没有元素
        for i in range(1, length):  # 1 -> length-1， 第零个为1，不需要再遍历，左闭右开
            L[i] = L[i - 1] * nums[i - 1]  # 左边的所有数的乘积
        R[length - 1] = 1  # 右侧没有元素
        for i in reversed(range(length - 1)):  # length-1-1 -> 0，最后一个为1，不需要再遍历
            R[i] = R[i + 1] * nums[i + 1]  # 右边的所有数的乘积
        for i in range(length):
            ans[i] = L[i] * R[i]
        return ans


if __name__ == '__main__':
    s = Solution()
    # print(s.productExceptSelf([1, 2, 3]))
    print(list(reversed(range(10 - 1))))
