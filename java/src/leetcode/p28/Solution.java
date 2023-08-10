package leetcode.p28;

//MINE，暴力法
//本题即为普通的模式串匹配算法，另有一个很出名且更快的算法KMP，这里不再描述
class Solution {
    public int strStr(String haystack, String needle) {
        int start; //start可以被优化掉，用代替i+j代替i++
        int n = haystack.length(), m =needle.length();
        //小优化
        //如果匹配，第一个字符加上模式串的长度一定小于等于字符串长度
        //注意边界情况，"="，如，"aa"与"aa"匹配，那么一定有0+2=2，索引为0。
        for (int i = 0; i+m <= n; i++) {
            boolean match = true;
            start = i;
            for (int j = 0; j < m; j++) {
                //本来这里应该先判断i < haystack.length()，但由于上面的优化i+m<=n，此条件一定符合，所以可去掉
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                } else {
                    match=false;
                    i=start;
                    break;
                }
            }
            if (match) return start;
        }
        return -1;
    }
}