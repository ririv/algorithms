package leetcode.p70;

//dp: f(x)=f(x−1)+f(x−2)
//

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1]; //包括第0级
        // 从第0级爬到第0级我们可以看作只有一种方案，即f(0)=1；
        // 从第0级到第1级也只有一种方案，即爬一级，f(1)=1。
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++){ //2->n
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}