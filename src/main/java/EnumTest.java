/**
 * Created by chenjie on 17/4/18.
 */
public class EnumTest {

    public static void main(String[] args) {

        String s = "s     tr     in      g";
        s=s.replaceAll(" +"," ");
        System.out.println(s);
       // System.out.println(Season.Spring.getName());
    }
}

 enum Season {
    Spring(1),Summer(2),Autumn(3),Winter(4);

    private String name;
    private int code;

    Season(int code) {
        this.code = code;
    }

    public String getName() {
        String chineseName = "";
        switch (code) {
            case 1:
                chineseName = "春天";
                break;
            case 2:
                chineseName = "夏天";
                break;
            case 3:
                chineseName = "秋天";
                break;
            case 4:
                chineseName = "冬天";
                break;
            default:
                chineseName = "";
        }
        return chineseName;
    }
}
