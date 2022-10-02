package leetcode.p11;

// 双指针
// 每次移动height较小的
// 具体证明查看 https://leetcode.cn/problems/container-with-most-water/solution/shuang-zhi-zhen-fa-zheng-que-xing-zheng-ming-by-r3/
public class Solution {
    public int maxArea(int[] height) {
        int currentArea, ans = 0;

        int l = 0, r = height.length - 1;

        while (l < r) {
            if (height[l] < height[r]) {
                currentArea = (r - l) * (height[l]);
                l++;
            } else {
                currentArea = (r - l) * (height[r]);
                r--;
            }
            ans = Math.max(currentArea, ans);
        }

        return ans;

    }
}
