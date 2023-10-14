package leetcode.p870;

import java.util.Arrays;

import static java.util.stream.IntStream.range;

// 贪心，田忌赛马
// 田忌赛马，对nums1，nums2排序，由于nums2不能变，所以是用索引进行排序（idx），用left和right记为idx2的两端指针，从left到right所指向的马的能力值越强
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx1 = range(0, nums1.length).boxed().toArray(Integer[]::new);
        Integer[] idx2 = range(0, nums2.length).boxed().toArray(Integer[]::new);
        Arrays.sort(idx1, (i1, i2) -> nums1[i1]-nums1[i2]);
        Arrays.sort(idx2, (i1, i2) -> nums2[i1]-nums2[i2]);
        int[] ans = new int[n];
        int left = 0, right=n-1;
        for (int i = 0; i<n; i++) {
            if (nums1[idx1[i]]>nums2[idx2[left]]){
                ans[idx2[left]] = nums1[idx1[i]];
                left++;
            }
            else {
                ans[idx2[right]] = nums1[idx1[i]];
                right--;
            }

        }
        return ans;

    }
}