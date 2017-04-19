package JavaBasis.daynamicproxy;

import Factory.User;

/**
 * Created by chenjie on 17/4/12.
 */
public class UserMgrImpl implements UserMgr {

    @Override
    public void insert() {
        System.out.println("......新增用户成功....");
    }

    @Override
    public void delete() {
        System.out.println("......删除用户成功....");
    }
}
