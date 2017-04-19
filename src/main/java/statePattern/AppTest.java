package statePattern;

/**
 * Created by chenjie on 16/8/1.
 */
public class AppTest {

    public static void main(String[] args) {
        Context context =new Context();
        StartState ss = new StartState();
        ss.doAction(context);
        System.out.println(context.getState().toString());
        EndState es = new EndState();
        es.doAction(context);
        System.out.println(context.getState().toString());
    }
}
