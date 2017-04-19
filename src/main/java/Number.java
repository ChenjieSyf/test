/**
 * Created by chenjie on 16/3/8.
 */
 enum  Numbers {

    RED("红色",1),GREEN("绿色",2),YELLOW("黄色",3);

    public static String getName(int index) {
        for (Numbers c : Numbers.values()) {
            if (c.getIndex() == index) {
                return c.value;
            }
        }
        return null;
    }

    private String value;
    private int index;

    private Numbers(String value,int i){

        this.value = value;
        this.index = i;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

public class Number{
    public static void main(String[] args){
        System.out.println(Numbers.getName(1));
    }

}