package strategy;

/**
 * Created by chenjie on 16/4/26.
 */
public class Clinet {

    public static void main(String[] args){
        Context context=new Context();

        context.exeCute(new ConcreateStrtegy1());

        context.exeCute(new ConcreteStategy2());
    }
}
