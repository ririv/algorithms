package leetcode.p46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.cn/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
// 回溯法，经典题目
// 本题建议看官方动画图理解
// 每一层对当前访问的数与后面的数分别交换
// 下一层当前访问的数+1
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 注意到给定类型 int[]，但结果说需要的类型为List<Integer>
        // 当然也可以在add时进行转换，但如果那样，每次都要转换，会损失效率，所以不如先转换一下
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backtrack(numsList, 0);
        return res;
    }

    public void backtrack(List<Integer> numsList, int visited) {
        int n = numsList.size();
        // 所有数都访问完了
        if (visited == n) { //n-1, n 均可
            //转成包装类型，再转成List，当然写法有很多种
            res.add(new ArrayList<>(numsList)); //一定要new一下实例，否则每次add的都是同一个实例，一个元素改变，另一个元素也跟着改变，导致所有结果都一样。
        }
        for (int i = visited; i < n; i++) {
            // 动态维护数组
            Collections.swap(numsList, visited, i);
            // 继续递归填下一个数
            backtrack(numsList, visited + 1);
            // 撤销操作
            Collections.swap(numsList, visited, i);
        }
    }
}
