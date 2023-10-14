package exam;

import java.math.BigDecimal;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String line = in.nextLine();
        String[] nums = line.split(" ");
        String a = nums[0];
        String b = nums[1];

        if (a.equals("0") || b.equals("0")) {
            System.out.println("0");
        }
        int m = a.length(), n = b.length();
        int[] arr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = a.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = b.charAt(j) - '0';
                arr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }
        int index = arr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(arr[index]);
            index++;
        }
        System.out.println(ans.toString());
    }
}

