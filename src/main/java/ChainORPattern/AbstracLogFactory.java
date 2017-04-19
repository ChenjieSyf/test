package ChainORPattern;

/**
 * Created by chenjie on 16/6/16.
 */
public abstract class AbstracLogFactory {

    public static int INFO = 1;
    public static int DEBUG = 1;
    public static int ERROR = 1;

    public int level;
    public AbstracLogFactory nextLogger;

    public AbstracLogFactory(int level) {
        this.level = level;
    }

    public void setNextLogger(AbstracLogFactory abstracLogFactory) {
        this.nextLogger = abstracLogFactory;
    }

    public void longMessage(int level, String message) {
        if (level <= this.level) {
            System.out.println("i shold show this message: " + message);
        }
        if (nextLogger != null) {
            nextLogger.longMessage(level, message);
        }
    }
}
