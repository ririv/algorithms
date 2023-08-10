package leetcode.p98;

import leetcode.definitions.binaryTreeNode.TreeNode;

// 递归为void的写法，这个写法更好理解些
class Solution {
    boolean ans = true;
    // 一定要在之前记录pre的值，不要使用参数传递
    // 参数传递的每一次递归的pre是不会变的
    // 但很明显，我们从左子树返回根节点并输出根节点值的时候，这一个pre的值我们是想要的改变后从左子树拿到的值，而不是此次递归中那个没有变化的pre的值
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        inorderDFS(root);
        return ans;
    }

    void inorderDFS(TreeNode root) {
        if (root == null) return;
        int current = root.val;

        inorderDFS(root.left);
        if (pre >= current) {
            ans = false;
            return; //已经知道结果为false了，直接return，没有再执行的必要了
        }
        pre = current;  //pre的值一定要在两个递归中间修改，改造递归遍历时，模板部分不变，只改打印节点值的那一个部分

        inorderDFS(root.right);

    }
}
