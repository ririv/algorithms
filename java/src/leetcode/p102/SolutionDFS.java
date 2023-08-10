package leetcode.p102;

import leetcode.definitions.binaryTreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

//面试特别要求 递归实现 dfs
//https://leetcode.cn/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/
//主要思想，递归时记录层次信息，这样就可以在ans中直接使用其作为索引得到那一层并加入结点
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return ans;
        dfs(1, root); //root作为第1层
        return ans;
    }

    void dfs(int level, TreeNode root) {

        if (ans.size() < level) { //如果ans的元素个数也就是结果的层数，达不到当前递归达到的层度，就给结果添加一层
            ans.add(new ArrayList<>());
        }
        ans.get(level - 1).add(root.val); //索引需要-1

        if (root.left != null) {
            dfs(level + 1, root.left);
        }
        if (root.right != null) {
            dfs(level + 1, root.right);
        }

    }
}
