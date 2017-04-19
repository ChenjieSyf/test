package thread;

import com.sun.javafx.tk.Toolkit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by chenjie on 16/6/16.
 */
public class MyFuture {

    public static void main(String[] args) {
        List<Future> list = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            Task task = new Task(i);
            list.add(executorService.submit(task));
        }
       /* for (Future f : list) {
            try {
                System.out.println(f.get());
            } catch (Exception e) {

            }

        }*/

        list.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (Exception e) {

            }

        });

    }
}

class Task implements Callable {
    private int i;

    public Task(int i) {
        this.i = i;
    }

    @Override
    public Object call() throws Exception {

        Random random =  new Random();

        System.out.println("this is " + Thread.currentThread().getName());
        return "syf is yours" + i;
    }
}
