package leetcode.p538;

import leetcode.definitions.binaryTreeNode.TreeNode;

class Solution {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null){
            convertBST(root.right);
            sum += root.val;  // 先计sum
            root.val = sum;  //再更新val
            convertBST(root.left);
        }
        return root;
    }
}
