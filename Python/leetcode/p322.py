# dp
# 定义 F(i) 为组成金额 i 所需最少的硬币数量
# dp[amount] = min(dp[amount - coin] + 1, dp[amount])
# dp[amount -coin]+1表示最后一枚硬币面额是coin，+1是为了加上此最后一枚硬币
from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float("inf")] * (amount+1)
        dp[0] = 0

        for coin in coins:
            for i in range(coin, amount+1):
                dp[i] = min(dp[i], dp[i-coin]+1)
        return dp[amount] if dp[amount] != float("inf") else -1