import java.util.Scanner;

class IO {
    public static void main(String[] args) {

        printf();

    }

    static void printf(){
        float PI = 3.141592654f;
        System.out.printf("%.2f", PI); //格式化输出
    }

    static void in(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
    }
}
