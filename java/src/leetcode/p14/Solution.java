package leetcode.p14;

// M
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();

        if (strs.length==0) return "";

        // 如果有一个为""，则必没有公共前缀
        for (String str : strs) {
            if (str.isEmpty()) {
                return "";
            }
        }

        int j = 0;
        outer:
        while (true) {
            for (int i = 1; i < strs.length; i++) {
                if (j>=strs[0].length() || j >= strs[i].length() || strs[0].charAt(j) != strs[i].charAt(j)) {
                    break outer;
                }
            }
            if (j<strs[0].length())
                ans.append(strs[0].charAt(j));
            else {
                break;
            }
            j++;
        }
        return ans.toString();
    }
}