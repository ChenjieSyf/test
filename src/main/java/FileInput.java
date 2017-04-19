import java.io.*;

/**
 * Created by chenjie on 16/4/23.
 */
public class FileInput {

    public static void main(String[] args) {
        File file = new File("/Users/chenjie/code/");


        try {


            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/chenjie/code/myfile.txt")));
            String data = null;
            int i = 0;
            while ((data = br.readLine()) != null) {

                if (i == 1999 || i == 3999 || i == 5999) {
                    System.out.println(data+")");
                } else {
                    System.out.print(data+",");
                }

                i++;
            }

        } catch (Exception e) {

        }


    }
}
