package leetcode.p55;

// 贪心。 如果能到达某个位置，那一定能到达它前面的所有位置。
class Solution {
    public boolean canJump(int[] nums) {
        int max_d = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max_d < i) return false; //不能到达当前位置
            else max_d = Math.max(max_d, i+nums[i]); //更新最远位置
        }
        return true;
    }
}