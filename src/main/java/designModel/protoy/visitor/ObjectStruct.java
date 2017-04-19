package designModel.protoy.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjie on 16/3/24.
 */
public class ObjectStruct {
    public static List<IElement> getList() {

        List<IElement> list = new ArrayList<IElement>();
        for (int j = 0; j < 10; j++) {
            int i = (int)( Math.random() * 100);
            System.out.println("========="+i);
            if (i < 50) {
                list.add(new Element1());
            } else {
                list.add(new Element2());
            }
        }
        return list;
    }
}
