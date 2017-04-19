package TiJavaTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

/**
 * Created by chenjie on 16/10/29.
 */
public class CjServer {

     static final int PORT=8089;

    public static void main(String[] args) throws Exception{

        InetAddress addr = InetAddress.getByName(null);
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = serverSocket.accept();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        while (true){
            String s = "";
            if(("End".equals(s=bufferedReader.readLine()))) break;
            System.out.println("read...is..."+s);
        }
    }
}
