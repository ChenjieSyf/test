/**
 * Created by chenjie on 16/10/8.
 */
public class TiJNiMingNeiBuLei {


    public Contents cont() {
        return new Contents() {
            private int i = 11;

            public int value() {
                return i;
            }
        }; // Semicolon required in this case
    }

    public static void main(String[] args) {
        TiJNiMingNeiBuLei p = new TiJNiMingNeiBuLei();
        Contents c = p.cont();
        System.out.println(c.value());
    }
}

interface Contents {
    int value();
}