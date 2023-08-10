package leetcode.p20;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                Character top = stack.peekFirst();

                if (top == null) return false;
                var a = switch (top) {
                    case '(' -> c == ')';
                    case '[' -> c == ']';
                    case '{' -> c == '}';
                    default -> false;
                };

                if (a) stack.pop();
                else return false;
            }
        }
        if (stack.peekFirst() == null) return true;
        else return false;
    }
}