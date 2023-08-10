package leetcode.p704;

class Solution {
    public int search(int[] nums, int target) {
        int low=0, high=nums.length-1;
        while (low<=high){ //注意"="，否则，如：nums[]长度为1的时候，会直接不进入循环，导致返回-1
            int mid = (high-low)/2 +low; //避免溢出
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}

