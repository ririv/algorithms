package leetcode.p62;


// dp
// 注意，此题最佳方案是排列组合，但很容易想到dp

//   dp[i][j] 是到达 i, j 最多路径
//   到达(i,j),共有两种方式，向右or向下，所以 dp[i][j] = dp[i-1][j] + dp[i][j-1]

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 第一行第一列只能为1。对应dp[0][0]，我们也设置为1，否则测试用例 m=1,n=1的预期答案为1，不通过
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}