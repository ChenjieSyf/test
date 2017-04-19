package file;

import java.io.*;
import java.util.SortedSet;
import java.util.logging.FileHandler;

/**
 * Created by chenjie on 16/10/17.
 */
public class InPutSomeThing {

    public static void main(String[] args) throws Exception {

        String s, s1, s2;


        //File file = new File("/Users/chenjie/Downloads");
       /* File file = new File(".");
        String[]  names =  file.list();

        for (int i = 0; i <names.length ; i++) {
            System.out.println(names[i]);
        }*/


      /*  DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("/Users/chenjie/Downloads/挪威的森林.txt")));

        while ((s=in.readLine())!=null){
            System.out.println(s);
        }
      */

        int c;
        StringBufferInputStream in2 = new StringBufferInputStream("/Users/chenjie/Downloads/挪威的森林.txt");
        while ((c = in2.read()) != -1) {
            System.out.println((char) c);
        }

    }
}
