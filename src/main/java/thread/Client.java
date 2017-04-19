package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjie on 16/4/28.
 */
public class Client {
    public static void main(String[] args) {
       /* List<String> list = new ArrayList<String>();
        list.add("chenjie");
        list.add("syf");
        list.add("cxh");
        ThradParam thradParam = new ThradParam(list);
        thradParam.start();*/

        for (int k = 0; k < 5; k++) {
            for (int i = 0; i <5 ; i++) {
                if(i==3) break;
                System.out.println("i ="+i+"k="+k);
            }
        }
    }
}
