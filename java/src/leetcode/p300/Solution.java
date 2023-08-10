package leetcode.p300;

// dp 经典问题
// O(n2) O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1; //初始化
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1; // 记得每个dp[i]也要初始化
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}