package ChainORPattern;

/**
 * Created by chenjie on 16/6/16.
 */
public class TestLog {

    public static AbstracLogFactory getLogChain(){
        AbstracLogFactory consol = new ConsolLog(1);
        AbstracLogFactory debug = new DebugLog(2);
        AbstracLogFactory error = new ErrorLog(3);

        debug.setNextLogger(consol);
        error.setNextLogger(debug);
        return error;
    }

    public static void main(String[] args) {

      AbstracLogFactory logFactory = getLogChain();

        logFactory.longMessage(1,"this is youyouyou");
    }
}
