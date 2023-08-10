package leetcode.p15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
// 本题需要注意的是 去重
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i - 1] == nums[i]) continue; //去重
            int L = i + 1, R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum < 0) {
                    //去重，必须放在前面，否则L先更新，一个元素可能还是重复的。
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    L++;
                } else if (sum > 0) {
                    while (L < R && nums[R] == nums[R - 1]) R--; //去重
                    R--;
                } else { // sum == 0
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //去重
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;

                }
            }
        }
        return ans;
    }
}