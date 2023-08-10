package leetcode.p54;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.cn/problems/spiral-matrix/solution/cxiang-xi-ti-jie-by-youlookdeliciousc-3/
//按层模拟

//首先设定上下左右边界
//其次向右移动到最右，此时第一行因为已经使用过了，可以将其从图中删去，体现在代码中就是重新定义上边界
//判断若重新定义后，上下边界交错，表明螺旋矩阵遍历结束，跳出循环，返回答案
//若上下边界不交错，则遍历还未结束，接着向下向左向上移动，操作过程与第一，二步同理
//不断循环以上步骤，直到某两条边界交错，跳出循环，返回答案

//索引递增反向：从上到下，从左到右


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;

        // 定义上下左右4个边界
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
//            Note =，为了保证四个循环的一致性（不乱），上面我们声明边界时用了-1，并统一在判断条件中加上=
            for (int i = left; i <= right; i++) { //沿着上边界，向右
                ans.add(matrix[up][i]);
            }
            //为了保证不乱，即 本来小的++，本来小的>本来大的 则跳出，本来的大小看上面声明立马就能得出
            if (++up > down) break; //重新设定上边界，若上边界大于下边界，则遍历遍历完成，下同

            for (int i = up; i <= down; i++) { //沿着右边界，向下
                ans.add(matrix[i][right]);
            }
            if (--right < left) break;

            for (int i = right; i >= left; i--) { //沿着下边界，向左
                ans.add(matrix[down][i]);
            }
            if (--down < up) break;

            for (int i = down; i >= up; i--) { //沿着左边界，向上
                ans.add(matrix[i][left]);
            }
            if (++left > right) break;
        }
        return ans;
    }
}