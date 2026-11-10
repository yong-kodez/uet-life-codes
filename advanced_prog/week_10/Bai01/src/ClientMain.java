import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2808);

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            BufferedReader networkIn = new BufferedReader(new InputStreamReader(is));
            PrintWriter networkOut = new PrintWriter(os, true);

            BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            while ((userInput = userIn.readLine()) != null) {
                networkOut.println(userInput);
                System.out.println(networkIn.readLine());
            }
            socket.close();
        } catch (Exception e) {}
    }
}
