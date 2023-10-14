package leetcode.p169;

// O(n) O(1)
// 如果我们把众数记为 +1+1+1，把其他数记为 −1-1−1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
// 可以理解为，不同数字相消除，消除到最后一定是众数
public class SolutionBoyerMoore {
    public int majorityElement(int[] nums) {
        int candi = nums[0], votes = 0;
        for (int num : nums) {
            if (votes == 0) { //票数=0，说明前面的数正好全部消完
                candi = num;
            }
            if (candi == num) { //相同，票数+1
                votes += 1;
            } else { //不同，抵消
                votes -= 1;
            }
        }
        return candi;
    }
}
