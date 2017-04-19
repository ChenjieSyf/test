package statePattern;

/**
 * Created by chenjie on 16/7/29.
 */
public class StartState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("starting........state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "StartState{}";
    }
}
