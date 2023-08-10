package leetcode.p200;

//为了求出岛屿的数量，我们可以扫描整个二维网格。如果一个位置为 11，则以其为起始节点开始进行深度优先搜索。在深度优先搜索的过程中，每个搜索到的 11 都会被重新标记为 00。
//最终岛屿的数量就是我们进行深度优先搜索的次数

// O(MN) O(MN)(最坏，整个网格均为陆地，深度优先搜索的深度达到MN)

//本题注意下grid是char类型
class Solution {
    public int numIslands(char[][] grid) {
        int h = grid.length;
        int w = grid[0].length;

        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(grid[i][j]=='1'){
                    dfs(grid, i,j);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int row, int col) {
        int h = grid.length;
        int w = grid[0].length;

        if (row < 0 || row >= h || col < 0 || col >= w) { //Note 第二个判断和第四个判断有 =
            return;
        }
        if (grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '2';

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}
