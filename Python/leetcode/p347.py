# 统计数量，一眼map
from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        fre = {}
        for i in range(len(nums)):
            fre[nums[i]] = fre.get(nums[i], 0)+1
        s = list(sorted(fre.items(), key=lambda x: x[1], reverse=True))
        print(s)
        res = []
        for i in range(k):
            res.append(s[i][0])
        return res