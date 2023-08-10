package leetcode.temp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.sort((o1, o2) -> o2.compareTo(o2));

        System.out.println(a);

    }
}

