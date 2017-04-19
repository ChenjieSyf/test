import org.joda.time.DateTime;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by chenjie on 16/6/21.
 */
public class StringUtil {

    public static void main(String[] args) throws Exception {
        /*String str = "%s you are my %s";
        System.out.println(String.format(str, "syf","crescen moon"));*/
/*
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setAge("0");
        User user1 = new User();
        user1.setAge("0");
        User user2 = new User();
        user2.setAge("0");
        user3.setAge("0");
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
       long test0 = list.parallelStream().filter(user4 -> user4.getAge().equals("0")).count();
      // int size =  list.stream().filter(user5 -> user5.getAge().equals("0")).map(user5 -> user5.getAge()).collect(Collectors.toList()).size();
      //  list.forEach(user5 ->System.out.println(user5.getAge()));
       System.out.println(test0);*/

        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,18);
        calendar.set(Calendar.MINUTE,25);
        calendar.set(Calendar.SECOND,0);
        String str = "\"点点滴滴\"";
        System.out.println(str.substring(1,str.length()-1));*/
      /*  String str = "E027561";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = "2016-08-16 11:36:00";
        System.out.println(sdf.format(new Date(1471245120000L)));
        System.out.println(sdf.parse(dateStr).getTime());

        String str1 = "cjc";
        System.out.println(str1.replace("c", "a"));*/
       /* StringJoiner sj = new StringJoiner(" ");
        sj.add("chenjiesyf");
        sj.add("syfchenjie");
        System.out.println(sj.toString());*/
       /* int i = 2;
        if (i == 1) {
            System.out.println(i);
        } else if (i == 2) {
            System.out.println(i);
        } else if (i == 3) {
            System.out.println(i);
        }*/
       /* String str = "中国勇夺17金！女排挺进四强！为勇者喝彩，饿了么和你一起拼，品牌5折日火热进行时！";
        System.out.println(str.length());
        System.out.println(str.substring(0, 40));
        // System.out.println(User.class.getField("age"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = "2016-10-10 16:39:00";
        System.out.println(sdf.format(new Date(381861717000L)));*/

        // System.out.println(sdf.parse(dateStr).getTime());  1471906800000L  1471903200000
        // System.out.println(sdf.parse(dateStr).getTime());

      /*  String str="2://web?url=https://h5.ele.me/sales/";
        String stt="eleme://web?url=https://h5.ele.me/sales/";
        System.out.println(encode(str));
        System.out.println(str.equals(stt));*//*
        StringBuilder sb = new StringBuilder();
        sb.append("1").append(",").append("2").append(",");
        System.out.println(sb.substring(0,sb.length()-1).toString());*/


     /*   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        System.out.println(sdf.format(calendar.getTime()));
        int today = calendar.get(calendar.DAY_OF_WEEK);
        calendar.add(Calendar.DAY_OF_MONTH, -(12+today));
        Date beginDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 35);
        Date endDate = calendar.getTime();
        HashMap<String, Object> map = new HashMap<>();
        map.put("bigin_date", sdf.format(beginDate));
        map.put("end_date", sdf.format(endDate));
        Object testStr = map.get("cj");
        System.out.println("2016-01-01".replace("-","/"));*/

        System.out.println("wm3yek".substring(0,6));
       // System.out.println(intArrayToString(new int[]{3, 4, 6}));


    }


    public static String encode(String url) throws Exception {
        StringBuffer sb = new StringBuffer();
        String httpUrl = "";
        if (url.contains("eleme://web?url=")) {
            httpUrl = URLEncoder.encode(url.replace("eleme://web?url=", ""), "utf-8");
            sb.append("eleme://web?url=").append(httpUrl);
        } else {
            sb.append(url);
        }

        return sb.toString();
    }

    public static String intArrayToString(int[] ints) {
        String weekStr = "";
        for (int i : ints) {
            weekStr += i;
        }
        return weekStr;
    }
}
