import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class LoggerUtil {
    private static final String LOG_FILE = "server.log";

    public static synchronized void log(String port, String eventType, String message) {
        String timestamp = LocalDateTime.now().toString();
        String logMessage = String.format("[%s] [%s] [%s] %s", timestamp, port, eventType, message);

        System.out.println(logMessage);

        FileWriter fw;
        PrintWriter pw;
        try {
            fw = new FileWriter(LOG_FILE, true);
            pw = new PrintWriter(fw, true);
            pw.println(logMessage);
            pw.flush();
        } catch (IOException e) {
            System.err.println("Logging error: " + e.getMessage());
        }
    }
}
