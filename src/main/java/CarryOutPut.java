import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenjie on 17/4/14.
 */
public class CarryOutPut {


    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100000 ; j++) {
                        System.out.println(Thread.currentThread().getName() +"==="+j);
                    }
                }
            });
        }
    }
}
