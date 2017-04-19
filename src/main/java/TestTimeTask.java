
import javafx.concurrent.Task;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by chenjie on 16/1/22.
 */
public class TestTimeTask {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws Exception {

        /*Thread1 thread1 = new Thread1();
        System.out.println("kaishi zhixing");
        // new Timer().schedule(thread1, 10000);
        String time = sdf.format(new Date()).substring(0, 10) + " 11:34:00";
        System.out.println(time);
        Date date = sdf.parse(time);

        new Timer().schedule(thread1, 1000);*/

        new TestTimeTask().timerManager();


    }


    public void timerManager() {
        Long delay = 1 * 60 * 1000L;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 15);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(sdf.format(calendar.getTime()));
     /*   MyTask myTask = new MyTask();
        Timer timer = new Timer();
        timer.schedule(myTask, calendar.getTime(), delay);*/
    }

    class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println(sdf.format(new Date()));
        }
    }
}

class Thread1 extends TimerTask {


    @Override
    public void run() {
        Thread2 thread2 = new Thread2();
        thread2.run();
    }
}

class Thread2 extends Thread {

    @Override
    public void run() {
        System.out.println("what a fuck leader");
        try {
            Thread2.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("fuck processeor");

    }




}

