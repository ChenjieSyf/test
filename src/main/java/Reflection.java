import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by chenjie on 16/8/19.
 */
public class Reflection {
    public static void main(String[] args) throws Exception{
        User user = new User();
        Method method = User.class.getMethod("testReflect", String.class);
      //  method.invoke(new User(),"syf");
       /* Field[] fs = user.getClass().getDeclaredFields();
        for(Field f:fs){

            System.out.println(f.getType()+" "+f.getName()+" "+f.getModifiers());

        }*/
        System.out.println(user.getClass().getField("age").getName());
    }
}
