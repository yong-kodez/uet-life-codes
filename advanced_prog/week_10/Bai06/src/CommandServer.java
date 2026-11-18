import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class CommandServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = null;
        try {
            server = new ServerSocket(5000);
            System.out.println("Server launch at port 5000");
        } catch (BindException e) {
            System.err.println("[!] Bind exception: port 5000 has been occupied (" + e.getMessage() + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.setSoTimeout(5000);
        while (true) {
            try {
                Socket client = server.accept();
                System.out.println("New client connected");

                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

                String cmd;
                while ((cmd = reader.readLine()) != null) {
                    if ("START".equalsIgnoreCase(cmd)) {
                        System.out.println("Received command: START -> System initializing...");
                        writer.println("System initializing...");
                    } else if ("SHUTDOWN".equalsIgnoreCase(cmd)) {
                        System.out.println("Received command: SHUTDOWN -> System shutdown...");
                        writer.println("System shutting down...");
                    }
                }
                client.close();
            } catch (SocketTimeoutException e) {
                System.err.println("[!] No interaction in the past 5s");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
