package leetcode.p78;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return ans;
    }

    public void backtrack(int current_index, int[] nums, List<Integer> temp) {
        // 为什么放在这里，而不是放在循环中
        // 其实两种差不多，每一次递归和每一次循环，都只会add一次
        // 但是同测试用例我们，发现，结果是需要包括 [] 的，放到这里，我们在第一次递归中，就也包含了这个情况
        // 如果放在循环中，请先在主函数中add [] 的情况
        // 写法详见solution2
        ans.add(new ArrayList<>(temp));

        for (int i = current_index; i < nums.length; i++) {
            temp.add(nums[i]); //选择
            backtrack(i + 1, nums, temp);
            temp.remove(temp.size() - 1); //撤销选择
        }
    }
}