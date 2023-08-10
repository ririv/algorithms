package leetcode.p215;

// 快排法
// 本题精髓在于快排每一次都能确定一个最终位置，因此不需要全部排序完毕


import java.util.Random;

// https://leetcode.cn/problems/kth-largest-element-in-an-array/solution/cpython3java-1da-gen-dui-diao-ku-2shou-l-xveq/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        // 在分解的过程当中，我们会对子数组进行划分，如果划分得到的 p 正好就是我们需要的下标，就直接返回 nums[p]；
        // 否则，如果 p 比target下标小，就递归右子区间，
        // 否则，递归左子区间。
        while (true) {
            int index = partition(nums, left, right);
            if (index == k - 1) //注意-1，因为索引从0开始，第k大从1开始
                return nums[index];
            else if (index < k - 1)
                left = index + 1;
            else
                right = index - 1;
        }

    }

    //----左右挖空互填
    public int partition(int[] nums, int left, int right) {
        // 这里可以优化，加个random
        // left 保存到 pivot, 可认为left挖空
        int pivot = nums[left];
        while (left < right) {
            // 本方法中每次选取的是一个第k大的元素
            // 因此第二个比较是相反的
            while (left < right && nums[right] <= pivot)
                right--;
            // right 填到left空位，此时可认为right挖空
            nums[left] = nums[right];
            while (left < right && nums[left] >= pivot)
                left++;
            // 注意此时left已经改变了，不再是原来的空位了，但right是空位，新left填上去，此时新left为空位
            nums[right] = nums[left];
        }
        //将一开始保存的pivot填上新的left空位。此时left即pivot
        nums[left] = pivot;
        // 返回pivot的索引left
        return left;
    }
}