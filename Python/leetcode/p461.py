class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        z = x ^ y
        res = 0
        while z > 0:
            res += z & 1
            z >>= 1
        return res


if __name__ == '__main__':
    print(Solution().hammingDistance(1, 4))
    # 1 & 4 = 5：0001 & 0100 = 0101
