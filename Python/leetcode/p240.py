from typing import List


# z字形查找
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        x = 0
        y = n - 1
        while x < m and y >= 0:
            if matrix[x][y] == target:
                return True
            elif matrix[x][y] > target:  # 位于第y列的元素都是严格大于 target 的，因此我们可以将它们全部忽略，
                y -= 1
            else:
                x += 1  # 位于第x行的元素都是严格小于target的，因此我们可以将它们全部忽略，
        return False
