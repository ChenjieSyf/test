import java.util.Scanner;

/**
 * Created by chenjie on 16/1/25.
 */
public class Fibo {


    public static void main(String[] args) {
        System.out.println("请输入菲波大小");
        int i = new Scanner(System.in).nextInt();

        System.out.println("最终的值为" + fib(i));

    }


    public static long fib(long n) {
        long f0 = 0;
        long f1 = 1;
        long f2 = 1;

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }
        for (int i = 3; i <= n; i++) {


            f2 = f1 + f0;
            f0 = f1;
            f1 = f2;


        }

        return f2;
    }
}
