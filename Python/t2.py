import math


def check(n):
    a = int(math.sqrt(n))
    return a * a == n


# 示例数据
edge = [[1 - 1, 2 - 1], [2 - 1, 3 - 1]]
node_weight = [3, 3, 12]
red_node = [0 for i in range(len(node_weight))]
max_red_count = 0
temp_red = 0


def maxred(edge_index):
    global temp_red
    global max_red_count
    if edge_index == len(edge):
        max_red_count = max(max_red_count, temp_red)
        return

    if red_node[edge[edge_index][0]] == 0 and red_node[edge[edge_index][1]] == 0 and check(
            node_weight[edge[edge_index][0]] + node_weight[edge[edge_index][1]]):
        temp_red += 1
        red_node[edge[edge_index][0]] = 1
        maxred(edge_index + 1)
        red_node[edge[edge_index][0]] = 0
        red_node[edge[edge_index][1]] = 1
        maxred(edge_index + 1)
        red_node[edge[edge_index][1]] = 0
        temp_red -= 1

    maxred(edge_index + 1)


maxred(0)

print("Maximum red nodes count:", max_red_count)
