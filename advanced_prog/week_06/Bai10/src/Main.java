public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getInstance();
        Logger errorLog = Logger.getInstance();
        System.out.println("Logger instances equals: " + (log.hashCode() == errorLog.hashCode()));

        log.logInfo("Application started");
        log.logInfo("Processing data...");
        errorLog.logError("Something ain't right");
    }
}
