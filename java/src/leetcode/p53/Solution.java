package leetcode.p53;

// dp
// 考虑nums[i]单独成段大，还是加上dp[i-1]这一段的和大
// 很明显，如果dp[i-1]<=0，那加上只会使和变小or不变，则dp[i] = nums[i]
// 如果dp[i-1]>0,那么加上后，会使和变大，是我们想要的，则dp[i] = dp[i-1]+nums[i]
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length]; //以i为结尾的子数组的最大和
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
