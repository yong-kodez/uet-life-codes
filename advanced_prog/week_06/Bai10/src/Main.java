public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getInstance();
        log.logInfo("Application started");
        log.logInfo("Processing data...");

        Logger errorLog = Logger.getInstance();
        errorLog.logError("Something ain't right");

        System.out.println("* Hashcode: ");
        System.out.println("  - log: " + log.hashCode());
        System.out.println("  - errorLog: " + errorLog.hashCode());
    }
}
