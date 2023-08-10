import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//二分查找中，先寻找target，再从此index分别向左向右搜索边界
//与官方题解不同，但此方法更容易理解
class Solution {
    public int[] searchRange(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        int idx = binarySearch(nums, target);
        int leftIdx = idx, rightIdx = idx;
        if (idx != -1) {
            while (leftIdx >= 0 && nums[leftIdx] == target) {
                leftIdx--;
            }
            while (rightIdx <= nums.length - 1 && nums[rightIdx] == target) {
                rightIdx++;
            }

            return new int[]{leftIdx + 1, rightIdx - 1}; //注意这里index是多计算了一位
        } else return new int[]{-1, -1};
    }

    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}