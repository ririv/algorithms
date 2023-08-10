package leetcode.p1;

import java.util.HashMap;
import java.util.Map;

// 原理：x+y = target
// 对于x，找到数组中是否包含y，那我们查询下target-x即可，使用hashmap使用有助于查找速度
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); //值，索引

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) { //是否包含y（target-x）
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i); //不包含，则将x放入map
        }
        return new int[0];
    }
}
