# 反序中序遍历（右根左），不难看出此规律，
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional

from leetcode.definitions.binary_tree_node import TreeNode


class Solution:
    def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        sum = 0
        def dfs(root):
            nonlocal sum
            if root:
                dfs(root.right)
                sum += root.val
                root.val = sum
                dfs(root.left)
        dfs(root)
        return root