public class AppConfig {
    private static AppConfig instance = null;
    private AppConfig() {};
    public static AppConfig getInstance() {
        if (instance != null)
            instance = new AppConfig();
        return instance;
    }    

}
