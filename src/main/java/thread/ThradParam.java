package thread;

import java.util.List;

/**
 * Created by chenjie on 16/4/28.
 */
public class ThradParam extends Thread {

    public List<String> list;

    public ThradParam(List<String> list){
        this.list = list;
    }

    @Override
    public void run() {
        System.out.println("+++++++++++++++++++++++"+list.size());
    }
}
