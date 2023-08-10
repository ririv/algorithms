package leetcode.p114;

import leetcode.definitions.binaryTreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 前序遍历，注意本方法是原地
class Solution {
    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        preorder(root);
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode cur = list.get(i);
            cur.left = null;
            cur.right = list.get(i + 1);
        }
    }

    void preorder(TreeNode root){
        if (root == null) return;
        list.add(root);
        preorder(root.left);
        preorder(root.right);

    }
}