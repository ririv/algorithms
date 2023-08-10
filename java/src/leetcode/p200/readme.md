https://leetcode.cn/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/

岛屿问题基本都可以用 **dfs 深度优先遍历** 解决

二叉树 基本dfs
```java
void traverse(TreeNode root) {
    // 判断 base case
    if (root == null) {
        return;
    }
    // 访问两个相邻结点：左子结点、右子结点
    traverse(root.left);
    traverse(root.right);
}
```

网格 基本 dfs
```java
    void dfs(char[][] grid, int row, int col) {
        int h = grid.length;
        int w = grid[0].length;

        // 判断坐标 (r, c) 是否越界
        if (row < 0 || row >= h || col < 0 || col >= w) { //Note 第二个判断和第四个判断有 =
            return;
        }
        if (grid[row][col] != '1') { // 如果这个格子不是岛屿，直接返回
            return;
        }

        grid[row][col] = '2'; // 将格子标记为「已遍历过」，避免重复遍历

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
```

- 0 — 海洋格子
- 1 — 陆地格子（未遍历过）
- 2 — 陆地格子（已遍历过）