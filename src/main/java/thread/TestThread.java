package thread;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chenjie on 16/4/13.
 */
public class TestThread extends Thread{

    private int threadNo;
    private Lock lock;

    public TestThread(int threadNo,Lock lock){
        this.threadNo = threadNo;
        this.lock = lock;
    }

    public static void main(String[] args) {

       /* ReentrantLock rl = new ReentrantLock();

        for (int i = 0; i < 10; i++) {
            TestThread testThread = new TestThread(i,rl);
            testThread.start();
        }
*/
      // String url =  "https://fuss10.elemecdn.com/e/53/a222eb82b725a6f4ed42a088da3dajpeg.jpeg";
       // System.out.println(url.replace("https","http"));
        int i  =2;
        System.out.println(i << 2);
    }

    @Override
    public void run() {
        lock.lock();
        for (int i = 0; i < 10000; i++) {
            System.out.println("this is"+threadNo +"  ---"+i);
        }
        lock.unlock();
    }
}
