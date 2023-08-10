package leetcode.p202;

import java.util.HashSet;
import java.util.Set;


/*1. 给一个数字,它的下一个数字是什么？
2. 按照一系列的数字来判断我们是否进入了一个循环。
第 1 部分我们按照题目的要求做数位分离，求平方和。
第 2 部分可以使用哈希集合完成。每次生成链中的下一个数字时，我们都会检查它是否已经在哈希集合中。
    如果它不在哈希集合中，我们应该添加它。
    如果它在哈希集合中，这意味着我们处于一个循环中，因此应该返回 false。*/

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        while(true){
            if (n==1) return true;
            else if(s.contains(n)) return false; //进入到无限循环
            else{
                s.add(n);
                n = getNext(n);
            }
        }
    }

    public int getNext(int n){
        int next = 0;
        while(n!=0){
            int a = n%10;
            next += a*a;
            n /=10;
        }
        return next;
    }
}