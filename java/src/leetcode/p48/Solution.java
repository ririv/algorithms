package leetcode.p48;

// 先水平旋转，再主对角线旋转, O(n2) O(1)
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length; //行数

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }
        //主对角线旋转，调换上三角的i，j即可
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) { //上三角，Note：如果j<n，则下三角又调换了一次，使矩阵又调回来
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}