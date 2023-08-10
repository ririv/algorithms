package leetcode.p66;

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int j = digits.length - 1; j >= 0; j--) {
            if (digits[j] != 9) {
                digits[j]++;
                for (int i = j + 1; i < digits.length; i++) { //i从j+1开始变0,digits[j]已经变动过
                    digits[i] = 0;
                }
                return digits;
            }
        }
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}
