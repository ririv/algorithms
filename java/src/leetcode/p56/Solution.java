package leetcode.p56;

import java.util.*;

// 1. 按照左端点升序排序
// 2. 如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾；
// 3. 否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            int last = merged.size() - 1;
            if (merged.size() == 0 || merged.get(last)[1] < L) {
//                merged.add(new int[]{L, R}); //官方例子
                merged.add(interval); //这里其实可以直接添加
            } else {
                merged.get(last)[1] = Math.max(merged.get(last)[1], R); //新的区间可有右边界没有旧区间的大，所以记得比较一下
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}