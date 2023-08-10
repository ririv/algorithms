package leetcode.p22;

import java.util.ArrayList;
import java.util.List;


// STAR
// 回溯，剪枝
// 可以用树形图表示出过程
// https://leetcode.cn/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
// 官方题解用的非剪枝回溯，但我觉得剪枝的方法更符合直觉
class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), n, n);

        return ans;
    }

    // leftNumRemained  还需要添加几个'('
    // rightNumRemained 还需要添加几个')'
    // 有一个小改动，使用的StringBuilder，而没有使用String，因为使用String类型，每次都会创建新的String，导致效率降低
    // Final类型，str + "a"，不会改变str，而是一个新的String
    void backtrack(StringBuilder current, int leftNumRemained, int rightNumRemained) {
        if (leftNumRemained == 0 && rightNumRemained == 0) { //全部添加完毕，加到结果中
            ans.add(current.toString());
            return;
        }

        // 剪枝
        // 产生右括号的时候，受到左括号的限制
        // 左括号数量一定是要大于右括号数量的，否则剪掉
        // 如"(()"，才可以继续，而"())"，一定不符合，剪掉
        // 转化下到剩余数量，对应于，剩余的左括号数量一定是要小于剩余的右括号数量，否则剪掉
        // 因此，剩余的左括号数量大于剩余的右括号数量时，剪掉
        if (leftNumRemained > rightNumRemained) return; //Note 不要忘了剪枝，注意谁大于谁

        if (leftNumRemained > 0) {
            current.append('(');
            backtrack(current, leftNumRemained - 1, rightNumRemained);
            // 回到上一层时，需要把添加的括号给删掉，
            // 当然，如果使用了String类型，就不需要这行代码了，因为每个递归调用中的的String都是独立的，与下一层和上一层均无关
            current.deleteCharAt(current.length() - 1);
        }

        if (rightNumRemained > 0) {
            current.append(')');
            backtrack(current, leftNumRemained, rightNumRemained - 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}