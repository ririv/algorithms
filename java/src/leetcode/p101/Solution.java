package leetcode.p101;

import leetcode.definitions.binaryTreeNode.TreeNode;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null || left.val != right.val) return false;
        else return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
