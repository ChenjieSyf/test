package Factory;

/**
 * Created by chenjie on 16/6/15.
 */
public class Doctor extends User {


    private String id;

    public String getId() {
        return "这是一个医生";
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("this is a doctor");
    }
}
