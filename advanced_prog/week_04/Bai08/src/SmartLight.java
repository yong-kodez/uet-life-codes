public class SmartLight extends OnOffDevice implements Adjustable {
    private int brightness;

    public SmartLight(String id, String name) {
        super(id, name);
    }

    @Override
    public void adjust(int value) { this.brightness = value; }
}
