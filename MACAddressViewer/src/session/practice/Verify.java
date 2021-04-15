package session.practice;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Verify {

    public Verify(String name) {
        System.out.println(name);
        InetAddress inetAddress;

        try {
            inetAddress = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(inetAddress);

            byte[] macAddress = network.getHardwareAddress();
            System.out.print("MAC address: ");

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < macAddress.length; i++) {
                builder.append(String.format("%02X%s", macAddress[i], (i < macAddress.length - 1) ? "-" : ""));
            }

            System.out.println(builder.toString());

        } catch (UnknownHostException | SocketException exception) {
            exception.printStackTrace();
        }
    }
}