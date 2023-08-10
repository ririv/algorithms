package leetcode.p14;

class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length == 0){
            return "";
        }
        for(int i=0; i<strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (i == str.length() || str.charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
