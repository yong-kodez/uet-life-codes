import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerMain {
    private static AtomicInteger tick = new AtomicInteger(0);
    
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2808);
            System.out.println("Server launch at port 2808");
            while (true) {
                Socket client = server.accept();
                LoggerUtil.log(client.getPort() + "", "CONNECT", "Client connected");
                ClientHandler handler = new ClientHandler(client, tick.getAndIncrement());
                Thread thread = new Thread(handler);
                thread.start();
            }
        } catch (Exception e) {}
    }     
}
