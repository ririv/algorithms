package leetcode.p122;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        //不要忘了初始化
        dp[0][0] = 0; //持有现金
        dp[0][1] = -prices[0]; //不持有现金（持有股票）

        for(int i = 1; i<n; i++){ //Note: 从1开始
            // 今天：持有现金，由昨天的两种状态得来
            // 无操作：昨天持有现金 | 有操作：昨天持有股票就卖
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            // 今天：持有股票，由昨天的两种状态得来
            // 无操作：昨天持有股票 | 有操作：昨天有现金就买
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]- prices[i]);
        }
        return dp[n-1][0]; //最后一天一定是持有现金
    }
}