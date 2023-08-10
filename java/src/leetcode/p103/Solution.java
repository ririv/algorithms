package leetcode.p103;

import leetcode.definitions.binaryTreeNode.TreeNode;

import java.util.*;

// 较简单
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;

        // 用于层序遍历的队列
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root); //记得添加根节点
        boolean isLeftOrder = true;
        while (!q.isEmpty()) {
            // 再构建一个双端队列，此队列用于记录每一层的节点。
            Deque<Integer> levelDeque = new LinkedList<>();
            //注意这里size不能放进循环中，因为循环中更新了队列，size会改变
            //而我们只需要当前层的节点数，不需要添加了下一层节点的节点数。
            int n = q.size();
            // 这里多了一层循环，为了在当前队列没有push新的子节点的情况下输出当前层的节点。
            for (int i = 0; i < n; i++) {
                var current = q.poll();
                if (isLeftOrder) {
                    levelDeque.offerLast(current.val); //顺序则添加到尾部
                } else {
                    levelDeque.offerFirst(current.val); //逆序这添加到首部
                }
                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }
            ans.add(new LinkedList<>(levelDeque)); //注意是链表，所以只要添加一个节点就等于添加了整个链表。
            isLeftOrder = !isLeftOrder;

        }
        return ans;
    }
}