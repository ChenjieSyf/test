package strategy;

/**
 * Created by chenjie on 16/4/26.
 */
public class Context {

    private IStrategy iStrategy;


    public void exeCute(IStrategy iStrategy) {
        iStrategy.doSomething();
    }
}
