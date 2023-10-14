# 树形dp
from functools import cache
from typing import Optional

from leetcode.definitions.binary_tree_node import TreeNode


class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:

        # 当前节点不做
        @cache # 本题需加上，相当于记忆话搜索，否则超时
        def dont(node):
            if node is None:
                return 0
            res = 0
            res += max(do(node.left), dont(node.left))  # 左子树，做or不做
            res += max(do(node.right), dont(node.right))  # 右子树，做or不做
            return res
        # 当前节点做
        @cache
        def do(node):
            if node is None:
                return 0
            res = node.val + dont(node.left) + dont(node.right)   # 做则把当前节点值加上，且左右子树都不能做
            return res
        return max(do(root), dont(root))