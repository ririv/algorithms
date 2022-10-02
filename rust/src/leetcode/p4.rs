use crate::leetcode::solution::Solution;

// https://leetcode.cn/problems/median-of-two-sorted-arrays/solution/3chong-jie-fa-qing-xi-jie-shi-ji-jian-cd-jm5p/


/*双指针法
申请2个指针，分别指向2个数组的头
每次比较大小来移动 2个指针
当指针移动的次数与 (m + n) / 2 相同时，得到中位数*/
impl Solution {
    pub fn find_median_sorted_arrays(nums1: Vec<i32>, nums2: Vec<i32>) -> f64 {
        let mut i = 0;
        let mut j = 0;
        let mut move_cnt = 0;
        let mut last = 0;

        let m = nums1.len();
        let n= nums2.len();

        // let mid = if total_len_is_odd {(nums1.len()+nums2.len())/2} else {(nums1.len()+nums2.len())/2 +1 };
        let mid_len = (m + n) / 2;
        // 2个指针在移动时，是否有超过2个数组的最大个数；
        // 如果有，后续就只能移动另一个指针
        let mut last_left = 0;
        while move_cnt <= mid_len {
            last_left = last;

            if i < m && j < n {
                if nums1[i] < nums2[j] {
                    last = nums1[i];
                    i += 1;
                } else {
                    last = nums2[j];
                    j += 1;
                };
            } else if i <m && j >= n {
                last = nums1[i];
                i += 1
            } else {
                last = nums2[j];
                j += 1
            }

            move_cnt += 1;
        }
        if (m+n)& 1 != 0 { last as f64 } else { { ((last_left as f64 + last as f64) / 2.0) } }    }
}