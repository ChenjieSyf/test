package thread;

import java.util.concurrent.Callable;

/**
 * Created by chenjie on 16/10/14.
 */
public class TestCallAble {

    public static void main(String[] args) throws Exception{

        BackThread bt = new BackThread();
        Exception o= (Exception)bt.call();
        ;
        System.out.println(o.getMessage());
    }


}
class BackThread implements Callable{
    @Override
    public Object call() throws Exception {
        return new Exception("this is a eg from jiege");
    }
}
