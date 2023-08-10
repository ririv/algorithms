package leetcode.p199;

import leetcode.definitions.binaryTreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.cn/problems/binary-tree-right-side-view/solution/jian-dan-bfsdfs-bi-xu-miao-dong-by-sweetiee/
//dfs
//也要掌握
class SolutionDFS {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {

        dfs(root, 0); //根节点深度是0
        return ans;
    }

    void dfs(TreeNode root, int depth) {
        if (root == null) return;
        //// 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
        if (depth == ans.size()) {
            ans.add(root.val);
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);

    }
}
