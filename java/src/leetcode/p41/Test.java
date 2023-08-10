package leetcode.p41;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        var data1 = new int[]{3, 4, -1, 1};
        var data2 = new int[]{1,1};
        var ans = solution.firstMissingPositive(data2);
        System.out.println(ans);
    }
}
