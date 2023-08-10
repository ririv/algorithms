package leetcode.p26;

public class Test {
    public static void main(String[] args) {
        int[] temp = new int[]{1, 1};

        SolutionM solution = new SolutionM();
        var ans = solution.removeDuplicates(temp);
        System.out.println(ans);
    }
}
