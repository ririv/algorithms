from typing import List


# 单调栈
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        ans = [0] * len(temperatures)
        stack = [] # 存放的是索引
        for i in range(len(temperatures)):
            while stack and temperatures[i]>temperatures[stack[-1]]:
                top = stack.pop()
                ans[top] = i-top
            stack.append(i)

        return ans
