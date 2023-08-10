package leetcode.p9;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) return false;

        int rev = 0;
        while (x > rev) { //仅需算到一半就好了，x最终为前半段，rev最终为后半段
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev / 10; //x长度为偶数 || x长度为奇数
    }
}
