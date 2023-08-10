package leetcode.p35;

//二分查找
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0, high = nums.length-1;
        int ans = nums.length;
        while(low<=high){
            int mid = (high-low)/2+low;
            if(target <= nums[mid]){
                ans=mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}