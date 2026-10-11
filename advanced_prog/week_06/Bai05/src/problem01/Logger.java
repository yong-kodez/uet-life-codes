public class Logger {
    private static volatile Logger instance;

    private Logger() {};

    public static Logger getInstance() {
        Logger log = instance;
        if (log == null) {
            synchronized (Logger.class) {
                log = instance;
                if (log == null) {
                    instance = new Logger();
                    log = instance;
                }
            }
        }
        return log;
    }
}
