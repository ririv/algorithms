# 我们目前持有一支股票，对应的「累计最大收益」记为 f[i][0]
# 我们目前不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」记为 f[i][1]
# 我们目前不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」记为 f[i][2]
from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        f = [[-prices[0],0,0] *3 for _ in range(n)]

        for i in range(1,n):
            f[i][0] = max(f[i-1][0], f[i-1][2] - prices[i])  # 啥也没干(继续持有)，前一天买了股票（不处于冷冻期才能买)
            f[i][1] = f[i-1][0] + prices[i]  # 处于冷冻期，说明前一天一定卖了股票，只有这一种情况
            f[i][2] = max(f[i-1][2], f[i-1][1])  #啥也不干（继续不持有），前一天卖了股票
        return max(f[n-1][1], f[n-1][2])  # 没有必要考虑f[n-1][0],因为最大收益肯定出现在卖了手上的股票的情况,当然，考虑了也是对的