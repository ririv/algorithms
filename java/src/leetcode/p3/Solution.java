package leetcode.p3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// 滑动窗口
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            // 每次左指针右移一位，移除set的一个字符，这一步会导致很多无用的循环。
            // while循环发现的重复字符不一定就是Set最早添加那个，还要好多次循环才能到达，这些都是无效循环，
            // 不如直接用map记下每个字符的索引，直接进行跳转
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}