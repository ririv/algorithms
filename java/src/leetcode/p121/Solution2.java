package leetcode.p121;

// dp
// 与贪心法一个思路
public class Solution2 {
    public int maxProfit(int[] prices) {
        //dp[i]表示截止到i，价格的最低点是多少   dp[i]=min(dp[i-1],nums[i])
        int ans = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            ans = Math.max((prices[i] - dp[i]), ans);
        }
        return ans;
    }
}
