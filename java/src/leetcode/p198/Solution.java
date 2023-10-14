package leetcode.p198;

//dp[k] = max{ dp[k-1], dp[k-2] + i }
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0; //没有房子，啥也偷不了
        dp[1] = nums[0]; //只有一个房子
        for (int i = 2; i <= nums.length; i++) { // 注意dp的i-1才对应nums的i
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}