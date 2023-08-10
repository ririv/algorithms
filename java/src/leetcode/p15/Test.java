package leetcode.p15;


import java.util.List;

public class Test {
    public static void p15() {
        Solution solution = new Solution();
        List<List<Integer>> ans = solution.threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0});
        System.out.println(ans);
    }
}
