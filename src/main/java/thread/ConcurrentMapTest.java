package thread;

import java.util.concurrent.*;

/**
 * Created by chenjie on 17/3/7.
 */
public class ConcurrentMapTest {

    private ConcurrentLinkedDeque<Integer> queue = new ConcurrentLinkedDeque<>();

    public ConcurrentMapTest() {
        for (int i = 0; i < 1000; i++) {
            this.queue.add(i);
        }
    }


    public static void main(String[] args) {
        ConcurrentMapTest concurrentMapTest = new ConcurrentMapTest();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new ThreadTask(concurrentMapTest.queue));
        }

    }


}

class ThreadTask implements Runnable {

    private ConcurrentLinkedDeque<Integer> deque;

    public ThreadTask(ConcurrentLinkedDeque<Integer> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        while (!deque.isEmpty()) {
            System.out.println( deque.poll());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }


    }
}