# dp(i,j)表示以 (i,j)为右下角，且只包含 1 的正方形的边长最大值。
from typing import List


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        row, col = len(matrix), len(matrix[0])
        dp = [[0] * col for _ in range(row)]
        max_side_length = 0
        for i in range(row):
            for j in range(col):
                if matrix[i][j] == '1':  # matrix[i][j]一定要为1才计算dp，否则dp[i][j]包含0，值肯定为0
                    if i == 0 or j == 0:
                        dp[i][j] = 1  # init
                    else:
                        dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
                max_side_length = max(max_side_length, dp[i][j])
        return max_side_length ** 2
