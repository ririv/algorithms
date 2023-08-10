package leetcode.p136;

// hash不满足空间o(1)题意
// 此题正确解法：异或^，将所有数字进行异或计算
class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num: nums) {
            single ^=num;
        }
        return single;
    }
}