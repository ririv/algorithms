package leetcode.p1004;

//滑动窗口
//https://leetcode.cn/problems/max-consecutive-ones-iii/solution/fen-xiang-hua-dong-chuang-kou-mo-ban-mia-f76z/
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int res = 0;
        int zeros = 0; //计数，0的数量
        while (right < nums.length) {
            if (nums[right] == 0) zeros++;

            while (zeros > k) {
                if (nums[left] == 0) zeros--;

                left++;
            }
            res = Math.max(res, right - left + 1); //与当前的长度相比较，当前为right - left + 1
            right++; //此语句必须放在上面的语句后面，因为比较的必须是当前的长度（在right尚未更新时）
        }
        return res;
    }
}