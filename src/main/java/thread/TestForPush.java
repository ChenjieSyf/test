package thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chenjie on 16/6/20.
 */
public class TestForPush {

    public AtomicInteger sendCount1 = new AtomicInteger(0);

    public AtomicInteger sendCount2 = new AtomicInteger(0);

    public static void main(String[] args) {

        // ScheduledExecutorService schedule = Executors.newScheduledThreadPool(5);
        /*for (int i = 0; i < 5 ; i++) {
            schedule.schedule(() -> {
                System.out.println("this is " + Thread.currentThread().getName());
            }, 10000, TimeUnit.MILLISECONDS);
        }*/
       /*    for (int i = 0; i < 5; i++) {
            schedule.schedule(new Callable<String>() {

                @Override
                public String call() throws Exception {
                    return "this is" + Thread.currentThread().getName();
                }


            }, 1000, TimeUnit.MILLISECONDS);
        }
        */

       /* List<Future> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(schedule.schedule(() -> {
                return "this is" + Thread.currentThread().getName();
            }, 10000, TimeUnit.MILLISECONDS));
        }

        // list.forEach(System.out::println);

        list.forEach(future -> {
            try {
                System.out.println(future.get().toString());
            } catch (Exception e) {

            }

        });*/

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list1.add(i);
            list2.add(i);
        }

        new TestForPush().hehe(list1, list2);
        // new TestForPush().hehe();

    }

    public void hehe(List<Integer> list1, List<Integer> list2) {

        new sendThread(list1, list2).start();
        System.out.println("终于完成了");
    }


  /*  class myThread extends Thread {
        public List<String> list;

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }

        public myThread(List<String> list) {
            this.list = new ArrayList<>();
            this.list.addAll(list);
        }

        @Override
        public void run() {
            list.forEach(string -> {
                System.out.println(string);
                try {
                    Thread.sleep(5000000);
                } catch (Exception e) {

                }

            });
        }
    }*/


    class sendThread extends Thread {
        private List<Integer> list1;
        private List<Integer> list2;

        ExecutorService executors = Executors.newFixedThreadPool(5);

        public sendThread(List<Integer> list1, List<Integer> list2) {
            this.list1 = list1;
            this.list2 = list2;
        }

        @Override
        public void run() {
            List<Integer> sendList1 = new ArrayList<>();

            List<Integer> sendList2 = new ArrayList<>();

            for (int i = 0; i < list1.size(); i++) {
                sendList1.add(list1.get(i));

                if (i != 0 && (i % 50 == 0 || i == list1.size()-1)) {
                    executors.execute(new mySendThread(sendList1, 1));
                    sendList1.clear();
                }
            }

            for (int i = 0; i < list2.size(); i++) {
                sendList2.add(list2.get(i));

                if (i != 0 && (i % 50 == 0 || i == list2.size()-1)) {
                    executors.execute(new mySendThread(sendList2, 2));
                    sendList2.clear();
                }
            }

            //System.out.println("facuqude zongtiaohsu=============" + sendCount.get());
        }
    }

    class mySendThread implements Runnable {

        private List<Integer> list = new ArrayList<>();

        private int type;

        mySendThread(List<Integer> list, int type) {
            this.list.addAll(list);
            this.type = type;
        }

        public List<Integer> getList() {
            return list;
        }

        public void setList(List<Integer> list) {
            this.list = list;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        @Override
        public void run() {


            try {
                if (type == 1) {
                    list.forEach(Integer -> {
                    });

                    sendCount1.addAndGet(list.size());
                    System.out.println("集合累计发送" + sendCount1.get());

                } else {
                    list.forEach(Integer -> {
                    });
                    sendCount2.addAndGet(list.size());
                    System.out.println("单个累计发送" + sendCount2.get());
                }
            } catch (Exception e) {
                list.forEach(Integer -> {
                });
            }


        }
    }
}
