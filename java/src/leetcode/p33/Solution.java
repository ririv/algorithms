package leetcode.p33;

//二分查找
//将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
//此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样无限划分.
//划分到最后一定会是有序的，因为只有1个元素时一定有序
// Note: 二分查找一定要注意 边界条件

// 变体：如果多次旋转呢，一样的做法。
// 无论旋转几次，都只相当于旋转一次，最多只有2段递增序列
//star
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = n - 1;

        while (left <= right) { //Note: =
            int mid = (left + right) / 2;
            if (nums[mid] == target) { //找到
                return mid; //返回索引mid
            }
            //寻找哪一部分有序，左边部分有序
            if (nums[0] <= nums[mid]) { // Note: =, 这里是由于mid是向下取整？
                // 与num[mid]比较，没有=是因为上面已经判断过==的情况（即找到的情况）
                // 不过此题中，就算加了=，也是正确的（已验证），因为在之前就已经返回了，程序不会运行到这里。
                if (nums[0] <= target && target < nums[mid]) { //确定target是否在这一部分，更改查找边界
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // 右边部分有序
                //同上
                if (nums[mid] < target && target <= nums[n - 1]) { //确定target是否在这一部分，更改查找边界
                    left = mid + 1;

                } else {
                    right = mid - 1;
                }

            }
        }

        return -1; //-1，没找到
    }
}