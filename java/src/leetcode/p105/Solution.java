package leetcode.p105;

import leetcode.definitions.binaryTreeNode.TreeNode;

import java.util.HashMap;

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return myBuildTree(preorder, 0, preorder.length-1, 0); //Note -1
    }


    public TreeNode myBuildTree(int[] preorder, int preorder_start, int preorder_end, int inorder_start) {
        if (preorder_start > preorder_end) {
            return null;
        }

        // 前序遍历中的第一个节点preorder_start就是根节点
        // 在中序遍历中定位根节点
        int inorder_root_index = map.get(preorder[preorder_start]);

        // 建立根节点
        TreeNode root = new TreeNode(preorder[preorder_start]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root_index - inorder_start;

        // 递归地构造左子树
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        // +1 是由于第一个元素是root，非左子树中的元素
        root.left = myBuildTree(preorder, preorder_start + 1, preorder_start + size_left_subtree, inorder_start);

        // 递归地构造右子树
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, preorder_start + size_left_subtree + 1, preorder_end, inorder_root_index + 1);
        return root;
    }
}