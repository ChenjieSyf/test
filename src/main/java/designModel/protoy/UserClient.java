package designModel.protoy;

/**
 * Created by chenjie on 16/3/7.
 */
public class UserClient {
    public static void main(String[] agrs) {
        ConcretePrototype concretePrototype = new ConcretePrototype();
        try {
            ConcretePrototype cp =(ConcretePrototype) concretePrototype.clone();
            cp.show(1);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
