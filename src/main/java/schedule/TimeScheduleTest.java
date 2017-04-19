package schedule;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by chenjie on 17/3/20.
 */
public class TimeScheduleTest {



    public static void main(String[] args) {
        new TimeScheduleTest().timeManager();

    }


    public  void timeManager(){
        Long delay = 24*60*60*1000L;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,11);
        calendar.set(Calendar.MINUTE,15);
        calendar.set(Calendar.SECOND,0);
        Timer timer = new Timer();
        Task task= new Task();
        timer.schedule(task,calendar.getTime(),delay);

    }


}


class Task extends TimerTask{
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void run() {
        System.out.println("========"+sdf.format(new Date()));
    }
}