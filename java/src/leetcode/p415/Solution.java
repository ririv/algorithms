package leetcode.p415;

// 模拟小学加法
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int res = x + y + add;
            ans.append(res % 10); //仅添加当前位的数字
            add = res / 10; //进位
            i--;
            j--;
        }
        return ans.reverse().toString();
    }
}