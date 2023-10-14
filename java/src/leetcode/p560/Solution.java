package leetcode.p560;

// 枚举
// Python大概率超时，请使用方法二
// 方法二：前缀和+hash

class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for(int end =0; end<nums.length; end++){
            int sum = 0; //记录子数组的和
            for (int start=end; start>=0; start--){ //从后往前枚举子数组
                sum +=nums[start];
                if (sum==k){
                    ans++;
                }
            }
        }
        return ans;
    }
}
