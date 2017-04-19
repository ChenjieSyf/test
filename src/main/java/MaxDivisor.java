import java.util.Scanner;

/**
 * Created by chenjie on 16/1/25.
 */
public class MaxDivisor {

    public static void main(String[] args) {
        System.out.println("请输入两个约数,用逗号隔开");
        String input = new Scanner(System.in).nextLine();
        String[] a = input.split(",");
        int i = Integer.parseInt(a[0]);
        int j = Integer.parseInt(a[1]);
        if (i == 0 || j == 0) {
            System.out.println("0没有公约数");
            return;
        }
        if (i == j) {
            System.out.println("最大公约数为" + i);
            return;
        }
        if (i < j) {
            int max = 1;
            for (int k = 1; k <= i; k++) {
                if (j % k == 0 && i % k == 0) {
                    max = k;
                }
            }
            System.out.println("最大公约数为" + max);
        } else {
            int max = 1;
            for (int k = 1; k <= j; k++) {
                if (j % k == 0 && i % k == 0) {
                    max = k;
                }
            }
            System.out.println("最大公约数为" + max);
        }
    }

}
