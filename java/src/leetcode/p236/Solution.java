package leetcode.p236;

import leetcode.definitions.binaryTreeNode.TreeNode;

// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root; // p,q正好分布在左子树和右子树
        // 左边没有p，q，一定在右子树中，
        // 注意此时right可能也为null，即对应 left == null && right == null 的情况，没有找到，返回null
        else if (left == null) return right;
        else return left; // right ==null, 同上
    }
}