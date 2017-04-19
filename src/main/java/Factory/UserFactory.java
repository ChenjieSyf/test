package Factory;

/**
 * Created by chenjie on 16/6/15.
 */
public class UserFactory {


    public User getUser(String s) {

        if ("ys".equals(s)) {
            return new Doctor();
        } else if ("jc".equals(s)) {
            return new Police();
        }
        return null;
    }
}
