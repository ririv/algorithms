# 中心扩散法
# 枚举所有可能的回文中心，考虑回文长度是奇数和回文长度是偶数的两种情况


# 统一奇偶
class Solution:
    def countSubstrings(self, s: str) -> int:
        ans = 0
        n = len(s)
        for i in range(n * 2 - 1):  # 枚举所有中心的情况，注意i不是中心，是情况总数，此写法为统一奇偶两种情况
            l = i // 2
            r = i // 2 + i % 2
            while l >= 0 and r < n and s[l] == s[r]:
                ans += 1
                l -= 1
                r += 1
        return ans



# 分奇偶两种情况，好理解一些
class Solution2:
    def countSubstrings(self, s: str) -> int:
        ans = 0
        n = len(s)
        for i in range(n):
            l = i
            r = i
            while l >= 0 and r < n and s[l] == s[r]:
                ans += 1
                l -= 1
                r += 1
            l = i
            r = i+1
            while l >= 0 and r < n and s[l] == s[r]:
                ans += 1
                l -= 1
                r += 1
        return ans