package leetcode.p13;

public class SolutionM {
    public int romanToIntM(String s) {
        int[] integers = {900, 400, 90, 40, 9, 4, 1000, 500, 100, 50, 10, 5, 1};
        String[] romans = {"CM", "CD", "XC", "XL", "IX", "IV", "M", "D", "C", "L", "X", "V", "I"};

        int ans = 0;

//        String s2 = new StringBuffer(s);
        int index = 0;
        outer:
        while (index < s.length()) {

            for (int i = 0; i < romans.length; i++) {
                if (s.substring(index).startsWith(romans[i])) {
                    index = (i < 6) ? index + 2 : index + 1;
                    ans += integers[i];
                    continue outer;
                }
            }

        }
        return ans;
    }
}
