from typing import Optional

from leetcode.definitions.binary_tree_node import TreeNode


class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None: # 递归终止条件必须有
            return None
        self.invertTree(root.left)
        self.invertTree(root.right)
        root.left, root.right = root.right, root.left  # 放在dfs前后都行
        return root
