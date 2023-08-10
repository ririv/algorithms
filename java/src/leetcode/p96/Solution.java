package leetcode.p96;

// 给定一个有序序列 1...n，为了构建出一棵二叉搜索树，我们可以遍历每个数字 i，将该数字作为树根，
// 将 1...(i−1) 序列作为左子树，将 (i+1)...n 序列作为右子树。
// 接着我们可以按照同样的方式递归构建左子树和右子树。

class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}

