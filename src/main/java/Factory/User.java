package Factory;

import java.io.Serializable;

/**
 * Created by chenjie on 16/6/15.
 */
public class User implements Serializable{
    int i;

    public User(int i){
        this.i = i;
    }

    public User(){
        this.i = 1;
    }

    public void run() {
        System.out.println("this is parent");
    }
}
