package leetcode.p1;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Test {
    static Solution solution = new Solution();

    public static void main(String[] args) {
        var data1 = new int[]{1,2,3};
        Object ans = null;
        try {
            ans = Arrays.stream(solution.getClass().getMethods()).toList().get(0).invoke(solution, data1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(ans);
    }
}
