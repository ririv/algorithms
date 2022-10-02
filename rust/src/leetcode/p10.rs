use crate::leetcode::solution::Solution;

impl Solution {
    pub fn is_match(s: String, p: String) -> bool {
        // 在字符前面+" "，起到哨兵效果
        // 使得空串的除以得一统一。
        let vs = (" ".to_string() + &s).chars().collect::<Vec<_>>();
        let vp = (" ".to_string() + &p).chars().collect::<Vec<_>>();
        // 注意dp的长度+1，因此下标对应有偏差：dp[i,j] 对应的是 vs[i-1], vp[j-1]
        let mut  dp = vec![vec![false;vp.len()+1];vs.len()+1];
        dp[0][0] = true; //空串为true

        'loop1: for i in 1..=vs.len() {
            'loop2: for j in 1..=vp.len() {
                if vp[j-1] == '.' || vp[j-1] == vs[i-1] {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if vp[j-1] == '*' {
                    // 匹配0次，不要忘了此情况，即p的前一个字符与v的当前字符比较，即使不相等也是匹配成功，但*匹配终止，，v不变，p+2
                    // "abc" "abcd*" 可以匹配成功
                    if vs[i-1] != vp[j-2] && vp[j-2]!='.' {
                        dp[i][j] = dp[i][j - 2]
                    } else {
                        dp[i][j] = dp[i][j-1] || dp[i-1][j] || dp [i][j-2]
                    }
                }
            }
        }

        dp[vs.len()][vp.len()]
    }
}