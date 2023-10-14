import sys
import math

n = int(input())
n2 = int(math.sqrt(n))
a = input()
M = []
for i in range(n2):
    temp = []
    for j in range(n2):
        temp.append(a[i * n2 + j])
    M.append(temp)

d = {}
for i in range(n2):
    for j in range(n2):
        t = d.get(M[i][j], [])
        t.append((i, j))
        d[M[i][j]] = t

d2 = {}
for i, j in d.items():
    for n, (a, b) in enumerate(j):
        if not (a - 1, b) in j or (a + 1, b) in j or (a, b - 1) in j or (a, b + 1) in j:
            t = d2.get(a)
            t.append((a,b))
            d2[i] = t
print(d2)
