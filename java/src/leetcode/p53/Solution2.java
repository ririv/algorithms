package leetcode.p53;

//dp空间优化后版本
//考虑到dp[i]仅与dp[i-1]相关，那我们仅仅需要存储dp[i-1]即可
//使用pre代替dp[i-1]

//dp: f(i)=max{f(i−1)+nums[i],nums[i]}
class Solution2 {
    public int maxSubArray(int[] nums) {
        int pre = nums[0];
        int ans = pre;
        for (int i = 1; i < nums.length; i++) { //循环从1开始，因此pre初始值设为nums[0]
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(ans, pre);
        }
        return ans;
    }

    //官方例子
    //官方的例子中，pre设为0，for循环从0开始，这是因为
    //dp[0]初始化时本应初始化为nums[0]
    //现在，我们for从0开始，会多加了一次dp[0]
    //那如何统一处理呢，我们将dp[-1]即pre初始化为一个nums[0]的前一个元素nums[-1]
    //由于它是不存在的，计算dp[0]=max(dp[-1]+nums[0], nums[0])，dp[-1]不应该影响到结果
    //我们将dp[-1]即pre置0即可。
    //如此，dp[0] = max(dp[-1]+nums[0], nums[0]) = max(0+nums[0], nums[0]) = nums[0]
    //发现，等效于我们想要的初始化：dp[0] = nums[0]
    public int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) { //循环从0开始，pre初始值设为0
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
