package leetcode.p152;

//dp
class Solution {
    public int maxProduct(int[] nums) {
        int[] maxF = new int[nums.length];
        int[] minF = new int[nums.length];
        //初始化
        maxF[0] = nums[0];
        minF[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxF[i] = Math.max(nums[i], Math.max(nums[i] * maxF[i - 1], nums[i] * minF[i - 1]));
            minF[i] = Math.min(nums[i], Math.min(nums[i] * maxF[i - 1], nums[i] * minF[i - 1]));
        }
        int ans = maxF[0];
        for (int i = 1; i < maxF.length; i++) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }
}