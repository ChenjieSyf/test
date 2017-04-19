import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenjie on 16/3/23.
 */
public class dataFormartter {
    public static void main(String[] agrs){
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        System.out.println(sdf.format(new Date(1458696600000L)));

    }
}
