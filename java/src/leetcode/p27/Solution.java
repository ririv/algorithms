package leetcode.p27;

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            else nums[k++] = nums[i];

            // 简化一下
//            if (nums[i] != val) nums[k++] = nums[i];
        }
        return k;
    }
}