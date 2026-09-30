public class SmartSpeaker extends OnOffDevice implements WifiConnectable, Adjustable {
    private int loudness = 0;
    
    public SmartSpeaker(String id, String name) {
        super(id, name);
    }

    @Override
    public void setUpWifi() {
        System.out.println(this.getName() + " connected to wifi");
    }

    @Override
    public void adjust(int value) { this.loudness = value; }
}
