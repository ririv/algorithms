# 栈
# https://leetcode.cn/problems/decode-string/solutions/264436/python3zhan-jian-ji-dai-ma-by-dreamcatcher_/
# 栈
# https://leetcode.cn/problems/decode-string/solutions/264436/python3zhan-jian-ji-dai-ma-by-dreamcatcher_/
class Solution:
    def decodeString(self, s: str) -> str:
        res = ""
        num = 0
        stack = []
        for c in s:
            if c.isdigit():
                num = num * 10 + int(c)
            elif c == '[':  # 入栈
                stack.append((res, num))
                res = ""
                num = 0
            elif c == ']':  # 出栈
                top = stack.pop()
                res = top[0] + res * top[1]
            else:
                res += c
        return res
