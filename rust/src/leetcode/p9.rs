// 回文数

use crate::leetcode::solution::Solution;

impl Solution {
    // 字符串法，但题目可能要求不许用字符串
    pub fn is_palindrome_1(x: i32) -> bool {
        x.to_string() == x.to_string().chars().rev().collect::<String>()
        // let temp = x.to_string().chars().collect::<Vec<_>>();
        //     let l = temp.len() - 1;
        //     for i in 0..l / 2 + 1 {
        //         if temp[i] != temp[l - i] {
        //             return false;
        //         }
        //     }
        //     true
    }

    // 本题的另一种思路，不转string，取最高位与最低位比较，注意一种取高位法 n / int(pow(10, floor(log10(n))));
    // 对于数字 1221，如果执行 1221 % 10，我们将得到最后一位数字 1，
    // 要得到倒数第二位数字，我们可以先通过除以 10 把最后一位数字从 1221 中移除，1221 / 10 = 122，
    // 再求出上一步结果除以 10 的余数，122 % 10 = 2，就可以得到倒数第二位数字。
    // 如果我们把最后一位数字乘以 10，再加上倒数第二位数字，1 * 10 + 2 = 12，
    // 就得到了我们想要的反转后的数字。如果继续这个过程，我们将得到更多位数的反转数字。
    pub fn is_palindrome(x: i32) -> bool {
        // a. 负数不是回文
        // b. 最后一位是0一定不是回文：最低位0没有与之对应的高位0
        if x < 0 || (x % 10 == 0 && x != 0) {
            false
        } else { // c. 其他情况
            let (mut x,mut rev) = (x, 0);
            while x> rev { // 很明显，我们仅需判断一半的位数即可
                rev = rev *10 + x%10;  //组合起来取的反转数字
                x /= 10; // 进位
            }
            // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
            // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
            // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
            x == rev || x == rev /10
        }
    }
}

