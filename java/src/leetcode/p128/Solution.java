package leetcode.p128;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// hash
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (int num: set) {
            if(!set.contains(num-1)){ //因为以num为起点，所以num-1一定不在set中
                int curLength = 1;
                int curNum = num; //直接是用num也行
                while (set.contains(curNum+1)){
                    curLength++;
                    curNum++;
                }
                maxLength = Math.max(curLength,maxLength);
            }
        }
        return  maxLength;
    }
}