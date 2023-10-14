from typing import List
import collections


# 拓扑排序
# 很容易想到 是否存在环，拓扑排序主要应用于此
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        edges = collections.defaultdict(list)
        visited = [0] * numCourses
        for i in prerequisites:
            edges[i[0]].append(i[1])

        loop = False

        def dfs(u):
            nonlocal loop
            visited[u] = 1
            for v in edges[u]:
                if visited[v] == 0:  # 未探索
                    dfs(v)
                    if loop:
                        return
                elif visited[v] == 1:  # 探索中
                    loop = True
                    return
            visited[u] = 2  # 探索完毕

        for u in range(numCourses):
            if not loop and visited[u] == 0:
                dfs(u)
        return not loop # loop是有环，所以与结果正好相反
