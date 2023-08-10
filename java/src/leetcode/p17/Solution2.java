package leetcode.p17;

import java.util.ArrayList;
import java.util.List;

// 非回溯法，此方法很快，采用的先求得所有可能性，再使用求余取模的方法得到每一种情况，进行填充
// 用时0ms，100%
class Solution2 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] strs = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //1.先算出一共有几种
        int len = 1;
        for (int i = 0; i < digits.length(); i++) {
            int c = digits.charAt(i) - '0';
            len *= strs[c].length();
        }

//再用求余方法拿到每一种
        for (int i = 0; i < len; i++) {
            int last = i;
            StringBuilder sb = new StringBuilder();
            for (int j = digits.length() - 1; j >= 0; j--) {
                int c = digits.charAt(j) - '0';
                int pos = last % strs[c].length(); //取模
                sb.append(strs[c].charAt(pos));
                last = last / strs[c].length();
            }
            result.add(sb.reverse().toString());
        }


        return result;
    }
}