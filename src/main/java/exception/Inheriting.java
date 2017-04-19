package exception;

/**
 * Created by chenjie on 16/10/14.
 */
public class Inheriting {

    public static void f() throws MyException {
        System.out.println(
                "Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        f();
        System.out.println(
                "Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace();
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }


}

class MyException extends Exception {
    public MyException() {

    }

    public MyException(String msg) {
        super(msg);
    }
}
