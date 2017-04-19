package thread;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenjie on 16/4/20.
 */
public class Concurrent {

    public static int amount=20000;

    public static void main(String[] args) {

       ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i <5 ; i++) {
            executor.execute(new Mythread());
        }
        executor.shutdown();
    }



   static class Mythread extends Thread{

        @Override
        public void run() {
            for (int i = 0; i <500 ; i++) {
                amount=amount-i;
                System.out.println(this.currentThread().getName()+"  "+amount);
            }
        }
    }
}
