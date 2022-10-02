package leetcode.p13;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 1; i < chars.length; i++) { //由于使用i-1，从1开始，否则越界

            if (getInt(chars[i - 1]) < getInt(chars[i]) && (chars[i - 1] == 'C' || chars[i - 1] == 'X' || chars[i - 1] == 'I')) {
                ans -= getInt(chars[i - 1]);
            } else {
                ans += getInt(chars[i - 1]);
            }
        }
        ans +=getInt(chars[chars.length-1]); //由于之前一直加的chars[i-1]，这样会少掉最后一个字符，现在给加上
        return ans;
    }

    public int getInt(char c){
        return switch (c) {
            case 'M' -> 1000;
            case 'D' -> 500;
            case 'C' -> 100;
            case 'L' -> 50;
            case 'X' -> 10;
            case 'V' -> 5;
            case 'I' -> 1;
            default -> throw new IllegalStateException("Unexpected value: " + c);
        };
    }

}
