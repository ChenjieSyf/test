package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chenjie on 16/9/6.
 */
public class BlockTest {

    static  ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        Mythread mythread = new  Mythread(reentrantLock);
        Mythread mythread1 = new  Mythread(reentrantLock);
        mythread.start();
        mythread1.start();
    }


}

class Mythread extends Thread {


    public Mythread(ReentrantLock reentrantLock){
        this.reentrantLock = reentrantLock;
    }
    ReentrantLock reentrantLock;
    @Override
    public void run() {
        reentrantLock.lock();
        System.out.println("i will sleep for sometimes");
        try {
            this.sleep(20000);
        } catch (Exception e) {

        }

     reentrantLock.unlock();
    }
}
