package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenjie on 16/4/21.
 */
public class YiCiZhiXing {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 4; i++) {
            executorService.execute(new TestThread());
        }
        executorService.shutdown();

    }

    static class TestThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 20000; i++) {
                System.out.println("===========" + this.currentThread().getName() +":::"+ i);
            }
        }
    }
}
