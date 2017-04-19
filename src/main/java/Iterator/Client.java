package Iterator;

/**
 * Created by chenjie on 16/4/26.
 */
public class Client {

    public static void main(String[] args) {
        ConcreteAggragate concreteAggragate = new ConcreteAggragate();
        concreteAggragate.add("chenjie");
        concreteAggragate.add("songyuefeng");
        concreteAggragate.add("chenxihan");
        concreteAggragate.add("songxiaodie");
        Itrator itrator = concreteAggragate.itrator();

        while (itrator.hasNext()) {
            System.out.println(itrator.next());
        }
    }
}
