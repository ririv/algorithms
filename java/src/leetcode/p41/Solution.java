package leetcode.p41;


//原地hash
//Note，此题hard，直接背诵
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
//            int num = Math.abs(nums[i]);
//            if (num <= n) {
//                nums[num - 1] = -Math.abs(nums[num - 1]);
//            }
            //这里必须abs，否则在标记（负值）可能标记到数组中还未遍历的值，使其变负值，索引越界
            int num = Math.abs(nums[i]);
            if (num <= n) { //Note，不是索引，是符合条件的正数，0是不算的，所以=
                // 这里必须有abs的原因是，如果数组中有重复值，如[1,1]
                // 会导致标记两次，不加abs，负负得正，又成了没有标记的情况。
                // 虽然不会越界，但在找第一个正数循环中，就会找到这个没有标记（实际上应该已经标记了）的数，导致结果出错
                nums[num - 1] = -Math.abs(nums[num - 1]); //Note 把num作为索引，索引要-1
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1; //返回的值，索引要+1
            }
        }

        return n + 1; //没有找到，因此+1

    }
}
