package designModel.protoy;

/**
 * Created by chenjie on 16/3/7.
 */
public class ProtoType implements Cloneable {


    public ProtoType clone() throws CloneNotSupportedException {
        ProtoType protoType = null;
        protoType = (ProtoType) super.clone();
        return protoType;
    }
}
