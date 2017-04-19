import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenjie on 17/3/14.
 */
public class Ecum implements Delayed {

    public long delayMilliTimes;
    public int id;

    public Ecum(int id, long delayMilliTimes) {
        this.delayMilliTimes = delayMilliTimes;
        this.id = id;
    }

    @Override
    public long getDelay(TimeUnit unit) {

        return  unit.convert(delayMilliTimes- System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if ((o == null) || !(o instanceof Ecum)) return 1;
        Ecum ecum = (Ecum) o;
        if (this.delayMilliTimes > ecum.delayMilliTimes) {
            return 1;
        } else if (this.delayMilliTimes == ecum.delayMilliTimes) {
            return 0;
        } else {
            return -1;
        }
    }

    public long getDelayMilliTimes() {
        return delayMilliTimes;
    }

    public void setDelayMilliTimes(long delayMilliTimes) {
        this.delayMilliTimes = delayMilliTimes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
