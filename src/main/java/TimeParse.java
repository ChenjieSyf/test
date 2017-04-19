import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by chenjie on 16/4/11.
 */
public class TimeParse {
    private static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String args[]) throws Exception {





      /*  Date date = new Date("Thu Mar 24 23:30:00 CST 2016");
        //  Date date = new Date("2016-05-06 12:12:12");

        Date date1 = new Date(date.getTime());
        String ss = sdf.format(date);
        sdf.parse(ss);
        System.out.println(sdf.parse(ss));*/

       /* SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String opTime = "10:05";

            Date opDate = sdf.parse(opTime);
            int second = opDate.getSeconds();
            int minutes = opDate.getMinutes();
            int hour = opDate.getHours();*/

       /* Pattern pattern = Pattern.compile("^\\w{32}$");
        String str="38b8c2c1093dd0fec383a9d9ac940515";
        System.out.println(str.length());
        System.out.println(pattern.matcher(str).matches());*/
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long time=sdf.parse("2016-12-06").getTime() -sdf.parse("2016-11-05").getTime();
        int day =(int) time/(24*3600*1000);
        System.out.println(day);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse("2016-12-02"));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK) );*/
        //  timeStampTaskUtil("2016-11-06","2016-12-06",new int[]{1,2,5});
       /* int[] a = new int[]{1,2,4};
        System.out.println(Arrays.toString(a));*/

        //timeStampTaskUtil("2016-11-06","2016-12-06",new int[]{0,5});

     /*   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date(1484581200000L)));
        System.out.println(sdf.parse("2017-01-18 17:48:00").getTime());*/
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse("2016-12-11"));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK) );*/



      //  System.out.println(sdf.parse("2017-03-30 17:52:00").getTime());

       /* 测试今天在calendar中是星期几
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse("2017-02-05"));
        System.out.println(calendar.);*/


        //测试某天在datetime中是星期几
       /* DateTime dateTime = formatter.parseDateTime("2017-02-12");
        System.out.println(dateTime.getDayOfWeek());*/

       //  timeStampTaskUtil("2017-02-01", "2017-02-15", new int[]{6, 7});
       // System.out.println(new TimeParse().longToDateFormatter(1491472800000L));

        System.out.println(new TimeParse().getClass().getResource("/"));


    }

    public static void timeStampTaskUtil(String startDate, String endDate, int[] weeks) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long time = sdf.parse(endDate).getTime() - sdf.parse(startDate).getTime();
        int day = (int) (time / (24 * 3600 * 1000));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(startDate));
        String dateStr = Arrays.toString(weeks);
        for (int i = 0; i < day; i++) {
            int weekOfDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;

            if (dateStr.contains(String.valueOf(weekOfDay > 0 ? weekOfDay : 7))) {
                System.out.println(sdf.format(calendar.getTime()) + ":" + calendar.get(Calendar.DAY_OF_WEEK));
            }
            calendar.add(Calendar.DATE, 1);
        }

    }

    public static int binaryConvert(int weeks[]) {

        int sum = 0;
        for (int i = 0; i < weeks.length; i++) {

            sum = sum + (int) Math.pow(2, weeks[i] - 1);
        }

        return sum;
    }

    public String longToDateFormatter(long l){
        return sdf.format(new Date(l));
    }

}
