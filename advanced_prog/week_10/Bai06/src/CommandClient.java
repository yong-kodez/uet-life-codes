import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

public class CommandClient {
    public static void main(String[] args) throws Exception {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 5000);         

            BufferedReader networkIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter networkOut = new PrintWriter(socket.getOutputStream(), true);
            
            System.out.println("- Sending START...");
            networkOut.println("START");
            System.out.println("-> Server response: " + networkIn.readLine());

            Thread.sleep(1000);

            System.out.println("- Sending SHUTDOWN...");
            networkOut.println("SHUTDOWN");
            System.out.println("-> Server response: " + networkIn.readLine());
            
        } catch (ConnectException e) {
            System.err.println("[!] Server is offline");
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
