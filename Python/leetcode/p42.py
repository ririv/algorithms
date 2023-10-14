# 双指针
from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        l = 0
        r = len(height) - 1
        l_max, r_max = 0, 0
        ans = 0
        while l < r:
            l_max = max(l_max, height[l])
            r_max = max(r_max, height[r])
            if height[l] < height[r]:  # 往右方向
                ans += l_max - height[l]
                l += 1
            else:  # 往左方向
                ans += r_max - height[r]
                r -= 1
        return ans
