import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);         
    }
}
