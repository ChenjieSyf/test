package test.suanfa;

import Factory.User;

/**
 * Created by chenjie on 16/8/2.
 */
public class digui {

    public static void recurision(int index){
        if(index==0){
            System.out.print("我的小鲤鱼");
        }else {
            System.out.print("抱起");
            index--;
            recurision(index);
        }
    }

    public static void main(String[] args)  throws Exception{
        System.out.print("吓的我");
        recurision(3);
        User user = new User(7);

    }
}
