import java.util.*;

/**
 * Created by chenjie on 16/1/20.
 */
public class TestMap {

    public static void main(String[] args){

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("marin","上单");
        map.put("faker","中单");
        map.put("madlife","辅助");
        map.put("imp", "ADC");
        map.put("penaut", "打野");

        Map<String,Object> map1= new TreeMap<String, Object>(map);

        Map<String,Object> map2 = new LinkedHashMap<String, Object>(map);

       // System.out.println(map1.toString());

       // System.out.println(map2.toString());

        Set<Map.Entry<String,Object>> set =  map.entrySet();

        System.out.println(set.toString());

    }
}
