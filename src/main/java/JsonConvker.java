import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;

import java.util.*;

/**
 * Created by chenjie on 16/7/29.
 */
public class JsonConvker {

    public static void main(String[] args) {
       /* String str = "{'amount':'30'}";
        Map<String, String> map = JSON.parseObject(str, new TypeReference<Map<String, String>>() {
        });
        String  result = "i am ${amount} hehe";
       // System.out.println("======"+(map.size()==0));
        for (String index : map.keySet()) {
            System.out.println("-------------"+result.replace("${"+index+"}",map.get(index)));
        }
*/
       /* User user = new User();
        user.setName("nihao");
        List<User> list = new ArrayList<>();
        list.add(user);
        System.out.println(JSON.toJSONString(list));*/

   /*     Random r = new Random();
        final String geoHash = "aabbcc123";
        final String deviceId = "bfce104e-5528-3d83-b51d-f1676f9d03fe";
// 		final String deviceId = "a6e5f0e1-8f35-3ae3-89b0-487f61a46c9e";	//jinshan
        final String caller = "me.ele";
//        final String caller = "me.ele.ios.eleme";		//ios
        final String appName = "me.ele";
        int userId = r.nextInt(9000000);

        String ubtMessage = "{"
                + "\"caller\":\"" + caller + "\","
                + "\"idfv\":\"" + deviceId + "\","    //iphone 测试机
                + "\"network_type\":\"WIFI\","
                + "\"http_request\":\"\\\"POST /collect/log HTTP/1.1\\\"\","
//    	 		+ "\"http_user_agent\":\"\\\"Rajax/1 Apple/iPhone7,2 iPhone_OS/9.2.1 me.ele.ios.eleme/5.11 ID/68D316DC-AF8C-429C-917D-255CB6862179; IsJailbroken/0\\\"\","
                + "\"http_user_agent\":\"\\\"Rajax/1 EDI-AL10/EDISON Android/6.0 Display/EDI-AL10C233B022 me.ele/6.4.1 ID/6b93a557-ea9c-3851-97c5-0d110b9f404b; KERNEL_VERSION:3.10.94 API_Level:23\\\"\","
                + "\"event_id\":\"1529\","
                + "\"type\":2,"
                + "\"app_name\":\"" + appName + "\","
                + "\"request_time\":\"0.005\","
                + "\"id\":29,"
                + "\"city_id\":1,"
                + "\"timestamp\":1479368807,"
                + "\"log_receive_time\":\"[21/Nov/2016:15:37:11 +0800]\","
                + "\"start_id\":\"69E4EF83-B17B-4452-9064-1272B23D505A\","
                + "\"user_id\":\"" + userId + "\","
                + "\"longitude\":121.228516,"
                + "\"msec\":\"1479368831.095\","
                + "\"status\":\"200 5\","
                + "\"hostname\":\"sh-hadoop-ubt-253-89.elenet.me-mobile-pubt.ele.me\","
                + "\"device_id\":\"" + deviceId + "\","
                + "\"params\":{"
                + "\"names\":\"9.9%E5%85%83%E4%B8%8B%E5%8D%88%E8%8C%B6,%E6%97%A0%E8%BE%A3%E4%B8%8D%E6%AC%A2,%E4%B8%8B%E5%8D%95%E5%87%8F10%E5%85%83,%E7%83%AD%E5%8D%96%E4%B8%8B%E5%8D%88%E8%8C%B6\""
                + "},"
                + "\"geohash\":\"" + geoHash + "\","
                + "\"ip\":\"172.16.24.133\","
                + "\"latitude\":31.0576125,"
                + "\"uuid\":\"96532C0F-2274-41E3-8636-A092A5CA5BD2\","
                + "\"is_in_background\":0,"
                + "\"page_name\":\"NVMHomeViewController\","
                + "\"channel\":\"huawei\","
                + "\"idfa\":\"FA7F9588-039A-4D5A-B8B5-B74A70A3354C\"}";

        JSONObject object = JSON.parseObject(ubtMessage);
        System.out.println(object.getString("user_id") + "========" + object.getString("geohash"));*/

        new JsonConvker().jsonStrToMap();
    }

    public void jsonStrToMap() {
        String str = "{\"婵鸣一夜\":\"434\",\"春江\":\"33\",\"花月一壶\":\"434\",\"type\":\"23\",\"夏乔\":\"3\"}";
        JSONObject jb = JSON.parseObject(str);
        Set<String> keySet = jb.keySet();
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        keySet.forEach(str1 -> {
           map.put(str1,jb.get(str1).toString());
        });

    }
}
