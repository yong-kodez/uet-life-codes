import java.util.HashMap;

public class ConfigCache {
    private HashMap<String, ImgConfig> cache;
    
    public ConfigCache() {
        cache = new HashMap<>();
        ImgConfig auto = new ImgConfig("auto", 0, new Pair(1600, 900));
        ImgConfig advanced = new ImgConfig("warm", 10, new Pair(1920, 1080));        

        cache.put("default", auto);
        cache.put("advanced", advanced);
    }    

    public ImgConfig get(String key) {
        return cache.get(key);
    }
}
