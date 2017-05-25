import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.io.*;
import java.util.Date;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenjie on 16/4/27.
 */
public class ThreadTest implements Runnable {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(3, this);

    public static void main(String[] args) throws Exception {
        // new ThreadTest().count();

        //System.out.println(testLeftShift(128));

       // new ThreadTest().testIO();
       // testOperator();
        bPrint((int)Math.pow(2,31));

    }

    public void testIO() throws Exception{
        File file = new File(this.getClass().getResource("") + "/cj.txt");
       // file = new File(System.getProperty("user.dir")+"/cj.txt");
        System.out.println(file.getPath());

        // System.out.println("==========="+file.exists());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
        String next = null;
        while ((next = bufferedReader.readLine()) != null) {
            System.out.println(next);
        }
        bufferedReader.close();
    }


    public static int testLeftShift(int i) {

        i <<= 64;
        return i;
    }


    public void count() {

        User u = new User();
        u.new DoNotKnow();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int j = 0; j < 3; j++) {

            FuckThread fuckThread = new FuckThread();
            executorService.execute(fuckThread);
            try {

                Thread.sleep(100000);
            } catch (Exception e) {

            }


        }
    }

    class FuckThread extends Thread {
        private int f;

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
                System.out.println("this is" + new Date());
            } catch (Exception e) {

            }

        }
    }

    @Override
    public void run() {
        System.out.println("屏障开始=========");
        for (int i = 0; i < 100000; i++) {
            System.out.println("this is" + i + "goodbye for shanghai");
        }
    }


    public static void testOperator(){
        int i = 10;
        i |= 12;
        System.out.println(-8>>>1);
    }

    static void bPrint(int i){
        for (int j = 31; j >=0 ; j--) {
            if(((1<<j) & i) !=0){
                System.out.print("1");
            }else {
                System.out.print("0");
            }
        }
    }
}
