package leetcode.p124;

import leetcode.definitions.binaryTreeNode.TreeNode;

// 此题虽标注hard，但很简单
// follow up: 打印路径
class Solution {
    int ans = Integer.MIN_VALUE; //有负值，因此我们不定义为0；

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0; //空节点不贡献任何值

        int leftSubtreeSum = dfs(root.left);
        int rightSubtreeSum = dfs(root.right);

        int currentPathSum = root.val + Math.max(leftSubtreeSum,0)+ Math.max(rightSubtreeSum,0);

        if (ans < currentPathSum) {
            ans = currentPathSum;
        }

        return root.val + Math.max(Math.max(leftSubtreeSum, rightSubtreeSum),0);  //往左子树走，还是往右左子树走，还是都不走
    }
}