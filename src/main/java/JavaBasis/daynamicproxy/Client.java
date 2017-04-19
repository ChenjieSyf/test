package JavaBasis.daynamicproxy;

import Factory.User;

import java.lang.reflect.Proxy;

/**
 * Created by chenjie on 17/4/12.
 */
public class Client {

    public static void main(String[] args) throws Exception{
        UserMgr mgr = new UserMgrImpl();

        //为用户管理添加事务处理
        InvocationHandler h = new TransactionHandler(mgr);
        UserMgr u = (UserMgr)NewProxy.newProxyInstance(UserMgr.class,h);

        //为用户管理添加显示方法执行时间的功能

        u.insert();
        System.out.println("\r\n==========华丽的分割线==========\r\n");
        u.delete();
    }
}
