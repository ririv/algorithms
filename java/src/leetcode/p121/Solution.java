package leetcode.p121;

// 贪心，如果我们在历史最低点买入。
// 本题也可使用dp

// 本题还有 其他变种，可能会一起考（尤其是2，p122），建议一起做
// https://leetcode.cn/circle/article/qiAgHn/
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            ans = Math.max(ans, price - minPrice);
        }
        return ans;
    }
}
