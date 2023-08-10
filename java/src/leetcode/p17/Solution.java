package leetcode.p17;

import java.lang.reflect.Array;
import java.util.*;


// MINE，此题官方方法是回溯法，但效率与本方法差不多
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) return ans;

        Map<Integer, String[]> alphabetMap = Map.of(
                2, new String[]{"a", "b", "c"},
                3, new String[]{"d", "e", "f"},
                4, new String[]{"g", "h", "i"},
                5, new String[]{"j", "k", "l"},
                6, new String[]{"m", "n", "o"},
                7, new String[]{"p", "q", "r", "s"},
                8, new String[]{"t", "u", "v"},
                9, new String[]{"w", "x", "y", "z"}
        );
        ans = new ArrayList<>(Arrays.asList(alphabetMap.get(Integer.parseInt(String.valueOf(digits.charAt(0))))));

        if (digits.length() == 1) return ans;


        int n = digits.length();
        int ans_num = ans.size();
        for (int i = 1; i < n; i++) { //变量digits
            int m = ans.size();
            String[] alphabet = alphabetMap.get(Integer.parseInt(String.valueOf(digits.charAt(i))));
            for (int j = 0; j < m; j++) {
                for (String letter : alphabet) {
                    ans.add(ans.get(j) + letter);
                }
            }
            ans_num *= alphabet.length;
        }

        return ans.subList(ans.size() - ans_num, ans.size());
    }
}