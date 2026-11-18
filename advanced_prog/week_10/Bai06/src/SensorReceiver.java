import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SensorReceiver {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(6000);
            System.out.println("UDP launch on port 6000");
            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String data = new String(packet.getData(), 0, packet.getLength());
                System.out.println("[Data] Received from " + packet.getAddress() + ": " + packet.getPort() + " -> " + data);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
