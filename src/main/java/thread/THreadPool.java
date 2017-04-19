package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenjie on 16/4/14.
 */
public class THreadPool {

    public static void main(String[] args) {

       // ExecutorService executor = Executors.newFixedThreadPool(3);
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Runnable() {
            public void run() {
                for (int i = 0; i < 200; i++) {
                    System.out.println("first thread " + i + " hello,mr.chen!");
                }
            }
        });
        executor.execute(new Runnable() {
            public void run() {
                for (int i = 0; i < 200; i++) {
                    System.out.println("second thread " + i + " hello,mr.chen!");
                }
            }
        });
        executor.execute(new Runnable() {
            public void run() {
                for (int i = 0; i < 200; i++) {
                    System.out.println("third thread " + i + " hello,mr.chen!");
                }
            }
        });

    }
}
