package nowcoder.nc331;

//https://www.nowcoder.com/practice/16409dd00ab24a408ddd0c46e49ddcf8
// 走n步到0的方案数=走n-1步到1的方案数+走n-1步到9的方案数。
// 到1是顺时针走，到9是逆时针走
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n int整型
     * @return int整型
     */
    public int circle(int n) {

        int K = 10; //点的个数为K(10)
        int mod = 1000000007; //结果可能特别大，要对mod取余 ？？？
        int[][] dp = new int[n + 1][K]; // dp[i][j]表示 从0出发走i步到点j有多少种方法，注意这里是n+1，因为算是了走0步（初始化）

        //init
        dp[0][0] = 1; //走0步到0，原地踏步，很明显又一种方法
        for (int j = 1; j < K; ++j) { //从1开始，不要覆盖了dp[0][0]
            dp[0][j] = 0; //走0步到其他点，原地踏步，很明显没可能，只有0种方法
        }


        //状态转移
//        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1]
        //因为题目是环，这里用的数组，所以要处理j-1，j+1越界问题
//        故 dp[i][j] =dp[i - 1][(j - 1 + K) % K] + dp[i - 1][(j + 1) % K]
        for (int i = 1; i <= n; ++i) { //从1开始，注意=
            for (int j = 0; j < K; ++j) {
                dp[i][j] = (dp[i - 1][(j - 1 + K) % K] + dp[i - 1][(j + 1) % K]) % mod;
            }
        }

        return dp[n][0];
    }
}
