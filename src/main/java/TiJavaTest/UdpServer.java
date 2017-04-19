package TiJavaTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by chenjie on 16/11/30.
 */
public class UdpServer {
    static final int INPORT = 1711;
    private byte[] buf = new byte[1000];
    private DatagramPacket dp = new DatagramPacket(buf, buf.length);
    private DatagramSocket socket;

    public UdpServer() {
       /* try {
            socket = new DatagramSocket(port);
            System.out.println("server start");
            while (true){
                String updStr = dp.getAddress() + String.valueOf(dp.getPort())+dp.getData();

                DatagramPacket echo =
                        Dgram.toDatagram(updStr,
                                dp.getAddress(), dp.getPort());
                socket.send(dp);

                socket.receive(dp);
                System.out.println(updStr);
            }

        } catch (Exception e) {

        }*/

        try {
            socket = new DatagramSocket(INPORT);
            System.out.println("Server started");
            while (true) {
                // Block until a datagram appears:
                socket.receive(dp);
                String rcvd = Dgram.toString(dp) +
                        ", from address: " + dp.getAddress() +
                        ", port: " + dp.getPort();
                System.out.println(rcvd);
                String echoString =
                        "Echoed: " + rcvd;
                // Extract the address and port from the
                // received datagram to find out where to
                // send it back:
                DatagramPacket echo =
                        Dgram.toDatagram(echoString,
                                dp.getAddress(), dp.getPort());
                socket.send(echo);
            }
        } catch (SocketException e) {
            System.err.println("Can't open socket");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Communication error");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new UdpServer();
    }

}
