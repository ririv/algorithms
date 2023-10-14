# 两个叶子节点的路径 = 根节点左右儿子的深度之和
# 最长路径，则维护一个max值即可

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        m = 0
        def depth(root):
            nonlocal m
            if root is None:
                return 0
            L = depth(root.left)
            R = depth(root.right)
            m = max(m, L+R+1)  # +1是root本身
            return max(L,R)+1
        depth(root)
        return m-1  # 此为经过的节点数目（由深度得出），而路径是线段数目，所以要-1
