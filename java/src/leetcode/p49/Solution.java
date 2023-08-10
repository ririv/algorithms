package leetcode.p49;

import java.util.*;

// 很容易想到map，单词string按字母排序后应该使一样的，然后放入map
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>>  map = new HashMap<>();
        for (var str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            //不要使用chars.toString(),返回的是hashCode()
            //Arrays.toString(chars)，可以用，但不好，打印出来的是数组形式的字符串
            //用new String(chars)最好
            var key =  new String(chars);
            var current = map.getOrDefault(key, new ArrayList<>());
            current.add(str);
            map.put(key, current);
        }
        return new ArrayList<>(map.values());
    }
}