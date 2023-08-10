package leetcode.p94;

import leetcode.definitions.binaryTreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return ans;
    }

    void inorder(TreeNode root){
        if(root==null) return;
        if(root.left != null) inorderTraversal(root.left);
        ans.add(root.val);
        if (root.right !=null) inorderTraversal(root.right);
    }
}
