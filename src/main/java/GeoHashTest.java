import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenjie on 17/3/14.
 */
public class GeoHashTest {


    public static void main(String[] args) {


        long alltime=0L;
        int j =0;
        while (j<100){
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 2000000; i++) {
                list.add(randomString());
            }
            list.add("chenjies");
            System.out.println("装载结束");
            long timeStart = System.currentTimeMillis();
            list.contains("chenjies");
            long timeEnd = System.currentTimeMillis();
            j++;
            alltime+=(timeEnd-timeStart);
        }

        System.out.println("平均时间"+alltime/100);

    }

    public static String randomString() {

        String str = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            char c = (char) random.nextInt(127);
            str += c;
        }
        return str;
    }
}
