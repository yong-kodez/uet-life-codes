import java.net.ServerSocket;
import java.net.Socket;
import java.awt.image.BufferedImageFilter;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class ServerMain {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2808);
            System.out.println("Server launch at port 2808");

            Socket clientSocket = serverSocket.accept();
            System.out.println("1 client connected");

            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();
        
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            PrintWriter writer = new PrintWriter(os, true);

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Client say: " + line);
                writer.println("Echo: " + line);
            }
            serverSocket.close();
        } catch (Exception e) {}
    }
}
