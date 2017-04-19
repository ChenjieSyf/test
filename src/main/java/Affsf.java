import java.io.*;

/**
 * Created by chenjie on 16/10/14.
 */
public class Affsf {

    interface Cast {
        public int get(int i);
    }

    public void d() {

        Cast o = (Cast) (int i) -> {
            System.out.println("hi");
            return i;
        };
        System.out.println(o.get(1));

    }


    public static Affsf.Cast getF(){
        return new Cast(){
            @Override
            public int get(int i) {
                return i*7+18;
            }
        };
    }

    public static void main(String[] args) throws Exception {
        /*Affsf affsf= new Affsf();
        affsf.d();*/
       /* File file = new File("
       ");
       // file.get
      //  DataInputStream dataInputStream = new DataInputStream();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String in;
        while ((in = reader.readLine()) != null) {
            System.out.println(in);
        }*/
        BufferedReader on = new BufferedReader(new InputStreamReader(new FileInputStream(".")));

        Affsf.Cast cc = getF();
        System.out.println(cc.get(12));
    }
}
