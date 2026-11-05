import java.io.InputStream;
public class ServerMain {
    public static void main(String[] args) {
        ServerSocket serverSocket = new ServerSocket(2808);
        System.out.println("Server launch at port 2808");

        Socket clientSocket = serverSocket.accept();
        System.out.println("1 client connected");

        InputStream is = clientSocket.getInputStream();
    }
    
}
