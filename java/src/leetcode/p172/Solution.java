package leetcode.p172;

class Solution {
    // 求每个数的质因子5的个数之和
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n!=0){
            n /= 5;
            ans += n; //不是求5的个数，右边是n不是1
        }
        return ans;
    }
}