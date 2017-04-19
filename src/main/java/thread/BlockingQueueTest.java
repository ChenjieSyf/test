package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by chenjie on 16/9/1.
 */
public class BlockingQueueTest {

    BlockingQueue<String> bb = new ArrayBlockingQueue<String>(5);

    public static void main(String[] args) throws Exception{

        BlockingQueueTest bt = new BlockingQueueTest();
        MyThread my =new MyThread();
        my.setBs(bt.bb);
        my.start();
        System.out.println("star to run next");
        String name =  bt.bb.take();
        System.out.println("this name is"+name);
    }

    static class MyThread extends Thread{

        BlockingQueue<String> bs;
        @Override
        public void run() {

            try {
                Thread.sleep(5000);
                bs.put("syf");
            }catch (Exception e){

            }

        }

        public BlockingQueue<String> getBs() {
            return bs;
        }

        public void setBs(BlockingQueue<String> bs) {
            this.bs = bs;
        }
    }
}
