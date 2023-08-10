package leetcode.p78;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        ans.add(new ArrayList<>()); //主函数中add [] 的情况
        return ans;
    }

    public void backtrack(int current_index, int[] nums, List<Integer> temp) {

        for (int i = current_index; i < nums.length; i++) {
            temp.add(nums[i]);
            //如果放在循环中，请放在add和remove中间的位置，以保证选择了元素
            ans.add(new ArrayList<>(temp));
            backtrack(i + 1, nums, temp);
//            ans.add(new ArrayList<>(temp)); //放在这里当然也可以
            temp.remove(temp.size() - 1);
        }
    }
}