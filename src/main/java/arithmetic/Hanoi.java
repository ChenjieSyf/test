package arithmetic;

/**
 * Created by chenjie on 16/8/30.
 */
public class Hanoi {

   //把托盘n-1当成一个整体
    public static void move(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println("move form " + A + " to " + C);
        } else {

            move(n - 1, A, C, B);
            move(1, A, B, C);
            move(n - 1, B, A, C);
        }

    }

    public static void main(String[] args) {
        move(5, 'A', 'B', 'C');
    }
}

