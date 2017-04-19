package TiJavaTest;

import java.net.DatagramPacket;
import java.net.InetAddress;

/**
 * Created by chenjie on 16/11/30.
 UDP编程
 */
public class Dgram {

    public static DatagramPacket toDatagram(String s, InetAddress inetAddress, int port) {

        byte[] buf = new byte[s.length() + 1];
        buf = s.getBytes();
        return new DatagramPacket(buf, buf.length, inetAddress, port);
    }

    public static String toString(DatagramPacket datagramPacket){
        return datagramPacket.getData().toString();
    }
}
