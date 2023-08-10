package leetcode.p32;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

//https://leetcode.cn/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
// 栈
// 始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，这样的做法主要是考虑了边界条件的处理，栈里其他元素维护左括号的下标
// 看官方题解图片动画即可理解
class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();

        int ans = 0;
        stack.push(-1); //虚空的')'索引-1
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else { //')'
                stack.pop(); //取出一个')'与'('配对
                if (stack.isEmpty()) { // 如果为空，说明上条语句的pop没有取到'('，而是取到了栈底的')'
                    stack.push(i); //将最后一个没有被匹配的')'的索引push
                //计算长度，stack.peek()是说匹配到的'('的前一个字符的索引，可能是最后一个还未匹配到的'('
                //也可能是，已经没有了'('，但还剩将最后一个没有被匹配的')'
                //因此没有此长度没有必要+1
                } else ans = Math.max(ans, i - stack.peek());
            }
        }
        return ans;
    }
}
