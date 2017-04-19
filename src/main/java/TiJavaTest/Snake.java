package TiJavaTest;

/**
 * Created by chenjie on 16/10/24.
 */
public class Snake {

    public Snake next;
    public char c;
    public Snake(int i,char x){
        c=x;
        if(--i>0){
         next = new Snake(i,(char)(c+1));
        }
    }

    @Override
    public String toString() {
        return "Snake{" +
                "next=" + next +
                ", c=" + c +
                '}';
    }

    public static void main(String[] args) {
        Snake s = new Snake(6,'a');
        System.out.println(s.toString());
    }
}
