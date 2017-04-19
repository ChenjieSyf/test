import java.util.Date;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenjie on 16/4/27.
 */
public class ThreadTest implements Runnable{

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(3,this);

    public static void main(String[] args) {
        new ThreadTest().count();


    }


    public void count(){

        User u = new User();
        u.new DoNotKnow();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int j = 0; j <3 ; j++) {

            FuckThread fuckThread = new FuckThread();
            executorService.execute(fuckThread);
            try {

                Thread.sleep(1000);
            }catch (Exception e){

            }


        }
    }

    class FuckThread extends Thread{
        private  int f;

        public int getF() {
            return f;
        }

        public void setF(int f) {
            this.f = f;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                System.out.println("this is"+new Date());
            }catch (Exception e){

            }

        }
    }

    @Override
    public void run() {
        System.out.println("屏障开始=========");
    }


}
