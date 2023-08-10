package leetcode.p26;


//双指针法
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p=0, q=1;
        while (q<nums.length){
            if(nums[p]!=nums[q]){ //nums[q-1]!=nums[q] 也可以
                nums[p+1] = nums[q];
                p++;
            }
            q++;
        }
        return p+1;
    }
}