package leetcode.p139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//dp
//分为两个字符串，s1=s[0..j-1], s2=s[j,i-1]
//字符串 s1 是否合法可以直接由 dp[j]得知，
//剩下的我们只需要看 s2是否合法即可，因此我们可以得出如下转移方程：
//dp[i]=dp[j]&&check(s[j..i−1])

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true; //空串可以被表示
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; //dp[i]，已经可以表示，需要break，否则后面可能更新dp[i]为不可表示的状态
                }
            }
        }
        return dp[s.length()];
    }
}
