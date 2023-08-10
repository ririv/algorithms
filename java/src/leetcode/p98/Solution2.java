package leetcode.p98;

import leetcode.definitions.binaryTreeNode.TreeNode;

class Solution2 {
    // 一定要在之前记录pre的值，不要使用参数传递
    // 参数传递的每一次递归的pre是不会变的
    // 但很明显，我们从左子树返回根节点并输出根节点值的时候，这一个pre的值我们是想要的改变后从左子树拿到的值，而不是此次递归中那个没有变化的pre的值
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return inorderDFS(root);
    }

    boolean inorderDFS(TreeNode root) {
        if (root == null) return true;
        int current = root.val;

        boolean res_left = inorderDFS(root.left);

        if (pre >= current) {
            return false;
        }
        pre = current; //pre的值一定要在两个递归中间修改

        boolean res_right = inorderDFS(root.right);

        return res_left && res_right;
    }
}
