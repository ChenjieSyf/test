import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenjie on 17/3/14.
 */
public class DelayueueTest {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws Exception {
        DelayQueue<Ecum> queue = new DelayQueue<>();

        Ecum ecum = new Ecum(1214, sdf.parse("2017-03-14 16:43:00").getTime() );
        Ecum ecum1 = new Ecum(1314, sdf.parse("2017-03-14 16:44:05").getTime() );
        Ecum ecum2 = new Ecum(2314, sdf.parse("2017-03-14 16:45:05").getTime() );
        queue.add(ecum);
        queue.add(ecum1);
        queue.add(ecum2);

        Ecum e;
        while ((e = queue.take()) != null) {


            System.out.println(e.getId() + "==========" + sdf.format(new Date(System.currentTimeMillis())));


        }
        System.out.println("完成");


        //System.out.println(sdf.format(new Date(System.currentTimeMillis())));

    }
}
