package leetcode.p63;

class Solution {
    // mine
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m-1][n-1] == 1) return 0;
        int[][] dp = new int[m][n];
        // 初始化第一列，只要碰到1，后面都无法到达
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) dp[i][0] = 1;
            else break;
        }
        // //初始化第一行，只要碰到1，后面都无法到达
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] != 1) dp[0][j] = 1;
            else break;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i-1][j] ==  1 && obstacleGrid[i][j-1] ==  1) dp[i][j] = 0;
                else if (obstacleGrid[i-1][j] ==  1) dp[i][j] = dp[i][j-1];
                else if (obstacleGrid[i][j-1] ==  1) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsWithObstacles_2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        //初始化第一列，只要碰到1，后面都无法到达
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1){
                break;
            }
            dp[i][0] = 1;
        }
        //初始化第一行，只要碰到1，后面都无法到达
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1){
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //自动跳过路障
                if (obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}