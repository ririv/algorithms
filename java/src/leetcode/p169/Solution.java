package leetcode.p169;

import java.util.HashMap;
import java.util.Map;

// hash
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            int times = map.getOrDefault(num, 0);
            map.put(num, times+1);
        }
        int ans = nums[0];
        for (int num: map.keySet()) {
            if (map.get(num) > nums.length/2) ans = num; //大于
        }
        return ans;
    }
}