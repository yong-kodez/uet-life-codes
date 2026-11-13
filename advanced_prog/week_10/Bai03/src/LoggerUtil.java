import java.time.LocalDateTime;

public class LoggerUtil {
    public LoggerUtil() {}
    public static synchronized void log(String eventType, String message) {
        String timestamp = LocalDateTime.now().toString();
        String logMessage = String.format("[%s] [%s] %s", timestamp, eventType, message);

        System.out.println(logMessage);
    }
}
