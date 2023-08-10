package leetcode.p16;

import java.util.Arrays;

// MINE，与官方题解思路一致
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {

            int L = i + 1, R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                res = Math.abs(res - target) > Math.abs(sum - target) ? sum : res;
                if (sum > target) {
                    //不知道为啥加了去重，反而变慢了，所以就不加了
//                    while (L<R && nums[R]== nums[R-1] ) R--;
                    R--;
                } else if (sum < target) {
//                    while (L<R && nums[L]== nums[L+1] ) L++;
                    L++;
                } else {
                    return target;
                }
            }
        }
        return res;
    }
}
