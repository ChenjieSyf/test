package TiJavaTest;

import Factory.User;

import javax.jws.soap.SOAPBinding;
import java.io.*;

/**
 * Created by chenjie on 16/10/25.
 */
public class Seriliaze {


    public static void main(String[] args) throws Exception{
        User user = new User(7);
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        ObjectOutputStream op =new ObjectOutputStream(buff);
        op.writeObject(user);
        ObjectInputStream ooup = new ObjectInputStream(new ByteArrayInputStream(buff.toByteArray()));
        User user1 = (User)ooup.readObject();
        System.out.println(user1.toString());

    }
}
