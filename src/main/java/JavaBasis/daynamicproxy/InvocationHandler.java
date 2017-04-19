package JavaBasis.daynamicproxy;

import java.lang.reflect.Method;

/**
 * Created by chenjie on 17/4/12.
 */
public interface InvocationHandler {

    public void invoke(Object o ,Method m);
}
