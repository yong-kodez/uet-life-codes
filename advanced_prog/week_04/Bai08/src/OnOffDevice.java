public abstract class OnOffDevice {
    private String id;
    private String name;

    public OnOffDevice(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() { return this.name; }
    
    public void turnOff() {
        System.out.println(this.name + " turned off");
    }
    public void turnOn() {
        System.out.println(this.name + " turned on");
    }
}
