package leetcode.p100;

import leetcode.definitions.binaryTreeNode.TreeNode;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false; //只有一个为空
        else if (p.val != q.val) return false; //根节点值
        else return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); //判断子树
    }
}
