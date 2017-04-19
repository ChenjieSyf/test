package TiJavaTest;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by chenjie on 16/10/29.
 */
public class CjClient {

    public static void main(String[] args) throws Exception{

        InetAddress inetAddress = InetAddress.getByName("localhost");
        Socket socket = new Socket(inetAddress,CjServer.PORT);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
        for (int i = 0; i <10 ; i++) {
            printWriter.println("hello"+i);
        }
        printWriter.println("End");
    }

}
