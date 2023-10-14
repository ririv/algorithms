from typing import List


class Solution:
    # O(nlogn)
    def countBits(self, n: int) -> List[int]:
        def countOnes(x):
            ones = 0
            while x > 0:  # 不能等于0
                x &= x - 1
                ones += 1
            return ones

        res = [countOnes(i) for i in range(n + 1)]
        return res

class Solution2:
    # O(n),dp,最低有效位
    def countBits(self, n: int) -> List[int]:
        def countOnes(x):
            ones = 0
            while x > 0:  # 不能等于0
                x &= x - 1
                ones += 1
            return ones

        res = [countOnes(i) for i in range(n + 1)]
        return res