/**
 * Created by chenjie on 15/11/25.
 */
public class TestPattern {


    public static void  main(String args[]){

        System.out.print(max(17,17).toString());
    }

    public static <E extends Comparable<E>> E max(E e1, E e2) {
        if (e1.compareTo(e2) > 0) {
            return e1;
        } else {
            return e2;
        }

    }
}
