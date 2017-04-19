import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjie on 16/6/12.
 */
public class Juer {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("chenjie");
        list.add("syf");
        list.add("sss");
        for (String str : list) {
            System.out.println("=====" + str);
            for (String str1 : list) {
                System.out.println(str1);
            }
        }
    }
}
