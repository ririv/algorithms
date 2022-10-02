// 整数反转
// 注意i32溢出问题
// 方法：数学
// https://leetcode.cn/problems/reverse-integer/solution/rust-by-rise0chen/
use crate::leetcode::solution::Solution;

impl Solution {
    pub fn reverse(x: i32) -> i32 {
        let mut y = x;
        let mut ans: i32 = 0;
        while y != 0 {
            ans = match ans.checked_mul(10) {
                None => { 0 }
                Some(res) => {
                    match res.checked_add(y % 10) { //取末位数字
                        None => { 0 }
                        Some(res) => { res }
                    }
                }
            };

            y /= 10;
        }
        ans
    }
}