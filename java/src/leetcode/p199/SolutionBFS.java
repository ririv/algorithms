package leetcode.p199;

import leetcode.definitions.binaryTreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//层次遍历
//简单
class SolutionBFS {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if(current.left!=null) q.offer(current.left); //这里current不会空指针的，不用管，因为我们是根据队列现有的size poll()的。
                if(current.right!=null) q.offer(current.right);
                if(i==size-1) ans.add(current.val);
            }
        }
        return ans;
    }
}
