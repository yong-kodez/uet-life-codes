public class SmartLight {
    private String id;
    private String name;
    private int brightness;

    public SmartLight(String id, String name, int brightness) {
        this.id = id;
        this.name = name;
        this.brightness = brightness;
    }
    public SmartLight(String id, String name) {
        this(id, name, 50);
    }

    public String getName() { return this.name; }
    public int getBrightness() { return this.brightness; }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
    public void setBrightness(String preset) {
        // if ("MAX".equals(preset)) this.setBrightness(100);
        if (preset == "MAX") this.setBrightness(100);
        else if (preset == "MIN") this.setBrightness(10);
        else if (preset == "ECO") this.setBrightness(30);
    }
    public void connectToHub(CentralHub hub) {
        hub.registerDevice(this);
    }
    
}
