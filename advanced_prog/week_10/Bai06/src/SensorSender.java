import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SensorSender {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            String message = "Temp: 28°C, Humidity: 65%";

            byte[] data = message.getBytes();
            InetAddress address = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(data, data.length, address, 6000);

            socket.send(packet);
            System.out.println("Successfully send UDP packet to localhost:6000");
            System.out.println("Message: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
