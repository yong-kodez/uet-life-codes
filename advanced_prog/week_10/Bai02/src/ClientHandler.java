import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private int id;
    public ClientHandler(Socket socket, int id) {
        this.clientSocket = socket;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            PrintWriter writer = new PrintWriter(os, true);
            String line;
            int port = clientSocket.getPort();
            while ((line = reader.readLine()) != null) {
                LoggerUtil.log(port + "", "RECEIVE", "[" + id + "] Client say: " + line);

                writer.println("Echo: " + line);
                LoggerUtil.log(port + "", "SEND", "Echo: " + line);
            }
        } catch (Exception e) {}
        finally {
            LoggerUtil.log(clientSocket.getPort() + "", "DISCONNECT", "Client disconnected");
        }
    }
}
