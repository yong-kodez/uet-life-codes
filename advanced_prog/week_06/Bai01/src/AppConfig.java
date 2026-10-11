public class AppConfig {
    private static volatile AppConfig instance;
    private String appName;
    private String version;
    private String logLevel;
    
    private AppConfig() {
        this.appName = "My App";
        this.version = "2.0";
        this.logLevel = "NORMAL";
    }

    public static AppConfig getInstance() {
        AppConfig result = instance;
        if (result == null) {
            synchronized (AppConfig.class) {
                result = instance;
                if (result == null) {
                    instance = new AppConfig();
                    result = instance;
                }
            }
        }
        return result;
    }    
}
