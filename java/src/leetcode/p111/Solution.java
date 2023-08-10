package leetcode.p111;


import leetcode.definitions.binaryTreeNode.TreeNode;

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int min_depth;

        if (root.left != null && root.right != null) min_depth = Math.min(minDepth(root.left), minDepth(root.right));
        else if (root.left != null) min_depth = minDepth(root.left);
        else min_depth = minDepth(root.right);
        return min_depth + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right != null) return Math.min(minDepth(root.left), minDepth(root.right))+1;
        else if (root.left != null) return minDepth(root.left) + 1;
        else return minDepth(root.right) + 1;
    }
}