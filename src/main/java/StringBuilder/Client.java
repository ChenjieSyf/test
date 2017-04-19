package StringBuilder;

/**
 * Created by chenjie on 16/4/27.
 */
public class Client {

    public static void main(String[] args) {
        MySun mySun1 = new MySun();

        MySun mySun2 = new MySun();

        mySun1.setAge(12);
        mySun1.setName("cj");
        mySun1.setYear("my");

        mySun2.setName("cj");
        mySun2.setAge(12);
        mySun2.setYear("1992");

        System.out.println(mySun1.toString());
        System.out.println(mySun1.equals(mySun2));
    }
}
