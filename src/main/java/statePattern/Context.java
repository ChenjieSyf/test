package statePattern;

/**
 * Created by chenjie on 16/7/29.
 */
public class Context {
    public State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }


}
