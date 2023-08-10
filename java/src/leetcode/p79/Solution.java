package leetcode.p79;

// 回溯
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n=board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = check(board, visited, word, i,j,0);
                if (flag) return true;
            }
        }
        return false;
    }

    boolean check(char[][] board, boolean[][] visited, String word, int i, int j, int k){
        if (board[i][j] != word.charAt(k)) return false;
        else if (k == word.length()-1) return true;  // 当前字符匹配且到最后
        visited[i][j] = true;

        boolean res = false;
        int[][] directions = {{0,-1}, {0,1},{1,0},{-1,0}}; //往四个方向搜索
        for (int[] direction: directions) {
            int new_i = i+direction[0], new_j = j + direction[1];
            if (new_i >= 0 && new_i < board.length && new_j >= 0 && new_j < board[0].length) { //边界检查
                if (!visited[new_i][new_j]) {
                    boolean flag = check(board, visited, word, new_i, new_j, k+1); // 不要是用k++，也不要是用++k，会影响当前层的k，他应该是不变的，k+1，只会改变下一层的k。
                    if (flag) return true;
                }
            }
        }

        visited[i][j] = false; //没找到，回溯，标记为未访问
        return res;
    }
}