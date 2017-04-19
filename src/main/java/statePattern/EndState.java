package statePattern;

/**
 * Created by chenjie on 16/8/1.
 */
public class EndState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("end ... state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "EndState{}";
    }
}
