package leetcode.p36;

// hash o(1) o(1)
/*有效的数独满足以下三个条件：
        同一个数字在每一行只能出现一次；
        同一个数字在每一列只能出现一次；
        同一个数字在每一个小九宫格只能出现一次。
        */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        //记录每一行和每一列中的每个数字的出现次数
        int[][] row = new int[9][9]; //记录每一行中的每个数字的出现次数
        int[][] col = new int[9][9]; //记录每一列中的每个数字的出现次数
        int[][][] subBox = new int[3][3][9]; //记录每一个subBox的每个数字的出现次数
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int curNumber = board[i][j] - '0' - 1; //索引从0开始，因此-1
                    row[i][curNumber]++;
                    col[j][curNumber]++;
                    subBox[i / 3][j / 3][curNumber]++; // i/3 j/3 确定哪个subBox
                    if (row[i][curNumber] > 1 || col[j][curNumber] > 1 || subBox[i / 3][j / 3][curNumber] > 1) { //出现2则代表某个数出现了2次
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
