use crate::leetcode::solution::Solution;

// 最长回文子串
// 中心扩散
// 回文数的两种情况：
// 回文数长度为偶数，以某个字符对称，比较这个字符左右两边的字符。判断是否相等
// 回文数长度为奇数，以某两个字符中间对称，分别向两边遍历，判断是否相等
impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        fn center_spread(v: &Vec<char>, mut left: i32, mut right: i32) -> (i32, i32) {
            while left >= 0 && right < v.len() as i32 && v[left as usize] == v[right as usize] {
                left -= 1;
                right += 1;
            }
            (left + 1, right -1) //注意由于最后一层while循环索引偏移了，所以这里要修正
        }

        let v = s.chars().collect::<Vec<_>>();
        let mut ans = (0, 0);
        for i in 0..s.len() {
            let odd = center_spread(&v, i as i32, i as i32);
            let even = center_spread(&v, i as i32, i as i32 + 1);
            let current_res =  if odd.1 - odd.0 > even.1 - even.0 { odd } else { even };
            if ans.1-ans.0 < current_res.1 - current_res.0 {
                ans = current_res;
            }
        }

        String::from(&s[ans.0 as usize ..=ans.1 as usize])
    }
}