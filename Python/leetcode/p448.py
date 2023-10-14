from typing import List


# hash, o(n), o(n)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        m = {}
        for i in range(1, len(nums)+1):
            m[i] = False
        for num in nums:
            m[num] = True
        res = []
        for k,v in m.items():
            if v is False:
                res.append(k)
        return res
