package leetcode.p215;

import java.util.PriorityQueue;

// 优先队列
// 注意此题，要自己实现 PriorityQueue
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}
