package leetcode.p26;

//MINE
class SolutionM {
    public int removeDuplicates(int[] nums) {
        int k=0;

        if (nums.length==1) return k+1;

        for(int i=1; i<nums.length;i++){
            while (i<nums.length&&nums[i-1] == nums[i]) i++;
            nums[k++] = nums[i-1];
        }
        // 上述循环中，最后一项没有判断
        if (nums[nums.length-1]!=nums[nums.length-2])
            nums[k++] = nums[nums.length-1];

        return k;
    }
}





