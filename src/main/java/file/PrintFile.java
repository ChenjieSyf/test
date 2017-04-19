package file;

import java.io.*;
import java.util.zip.InflaterInputStream;

/**
 * Created by chenjie on 16/10/18.
 */
public class PrintFile extends PrintStream {
    public PrintFile(String filename)
            throws IOException {
        super(
                new BufferedOutputStream(
                        new FileOutputStream(filename)));
    }

    public PrintFile(File file)
            throws IOException {
        this(file.getPath());
    }

    public static void main(String[] args) throws Exception{
        File file = new File("/Users/chenjie/Downloads/挪威的森林.txt");
        BufferedInputStream in = new BufferedInputStream((new FileInputStream("/Users/chenjie/Downloads/挪威的森林.txt")));
        String s;
        int c;
        while ((c=in.read())!=-1){
            System.out.print((char) c);
        }
    }
}

