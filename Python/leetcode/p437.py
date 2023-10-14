# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional

from leetcode.definitions.binary_tree_node import TreeNode


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        def rootPathSum(root, targetSum):
            if root is None:
                return 0
            res = 1 if root.val == targetSum else 0  # 如果当前节点值直接等于targetSum，那么数量计1，否则为1

            res += rootPathSum(root.left, targetSum - root.val)
            res += rootPathSum(root.right, targetSum - root.val)
            return res
        if root is None:
            return 0
        # 以当前节点为根的子树的所有路径和
        res = rootPathSum(root, targetSum)
        # 遍历所有节点
        res += self.pathSum(root.left, targetSum)
        res += self.pathSum(root.right, targetSum)
        return res