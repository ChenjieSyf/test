package arithmetic;

/**
 * Created by chenjie on 16/8/30.
 */
public class recursion {

    public int recurfirst(int n){
        if(n==1){
            System.out.println(1);
            return 1;
        }else {
            System.out.print(n + "*");
            return n*recurfirst(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new recursion().recurfirst(10));
    }
}
