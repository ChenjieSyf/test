package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenjie on 16/4/14.
 */
public class Bingfa {

    private static Account account = new Account();

    public static void main(String[] args) {


        ExecutorService excutor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            excutor.execute(new AddTask());
        }

        excutor.shutdown();
        while (!excutor.isTerminated()) {

        }

        System.out.println(account.bance);
    }


    private static class Account {
        public int bance = 0;


        public void addBance(int amount) {

             bance = bance + amount;
            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }


        }

    }


    private static class AddTask implements Runnable {
        public void run() {
            account.addBance(1);
        }
    }
}

