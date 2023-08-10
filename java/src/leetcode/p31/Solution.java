package leetcode.p31;

import java.util.Arrays;


class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) { // 注意边界 i>0，否则i-1会越界
            if (nums[i] > nums[i - 1]) {    // 从后向前查找第一个相邻升序的元素对 (i-1, i)
//              此时[i,end) 必然是降序
//              我们先逆序，再找k（先找k，再逆序也一样的）
//              我们reverse一下，使其升序
                reverse(nums, i, len - 1);

//              在 [i,end) 查找第一个大于 A[i-1] 的值 A[k]
                for (int j = i; j < len; j++) {
                    if (nums[j] > nums[i - 1]) { //在[i,len)里找到第一个比 i-1 大的元素，交换
                        swap(nums, j, i - 1);
                        return;
                    }
                }

                //先找k，再逆序写法，官方思路
//                for (int j = len-1; j > i-1; j--) {
//                    if (nums[j] > nums[i - 1]) { //在[i,len)里找到第一个比 i-1 大的元素，交换
//                        swap(nums, j, i - 1);
//                        reverse(nums, i, len - 1);
//                        return;
//                    }
//                }

            }
        }
        reverse(nums, 0, len - 1); // 题目要求，如果不存在下一个更大的排列，则将数字升序排列
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

}
