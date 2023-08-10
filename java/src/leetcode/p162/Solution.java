package leetcode.p162;

//https://leetcode.cn/problems/find-peak-element/solution/hua-jie-suan-fa-162-xun-zhao-feng-zhi-by-guanpengc/
//注意题目条件，在题目描述中出现了 nums[-1] = nums[n] = -∞，这就代表着 只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
/*
 本题思路在于，比较a,b，我们可发现
 a<b，b满足了峰值的一个条件，b大于左侧值
 a>b, b满足了峰值的一个条件，a大于右侧值
*/
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
//            int mid = left + (right - left) / 2;
            int mid = (left + right) / 2;

            if (nums[mid] > nums[mid + 1]) { //此时(left, mid) 一定有峰值
                right = mid; //在左边段找
            } else { //nums[mid] <= nums[mid + 1]，此时 (mid+1, right)一定有峰值
                left = mid + 1; //在右半段找
            }
        }
        return left; //此时left与right发生碰撞，left==right，因此返回哪一个都可以
    }
}