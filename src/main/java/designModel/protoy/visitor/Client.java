package designModel.protoy.visitor;

import java.util.List;

/**
 * Created by chenjie on 16/3/24.
 */
public class Client {

    public static void main(String[] args) {
        List<IElement> eList = ObjectStruct.getList();
        for (int i = 0; i < eList.size(); i++) {
            eList.get(i).accept(new Visitor());
        }
    }

}
