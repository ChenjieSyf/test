package Factory;

/**
 * Created by chenjie on 16/6/15.
 */
public class Test {
    public static void main(String[] args) {
      /*  UserFactory userFactory = new UserFactory();

        User user = userFactory.getUser("jc");

        user.run();*/

        Doctor user =(Doctor) new User();
        user.run();
    }
}
