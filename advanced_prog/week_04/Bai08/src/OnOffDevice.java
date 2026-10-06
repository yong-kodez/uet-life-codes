public abstract class OnOffDevice {
    private String id;
    private String name;
    private int state;

    public static final int ON_STATE = 1;
    public static final int OFF_STATE = 0;

    public OnOffDevice(String id, String name) {
        this.id = id;
        this.name = name;
        this.state = OFF_STATE;
    }

    public String getName() { return this.name; }
    
    public void turnOff() {
        this.state = OFF_STATE;
        System.out.println(this.name + " turned off");
    }
    public void turnOn() {
        this.state = ON_STATE;
        System.out.println(this.name + " turned on");
    }
}
