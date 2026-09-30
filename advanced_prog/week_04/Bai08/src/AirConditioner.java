public class AirConditioner extends OnOffDevice implements WifiConnectable {
    public AirConditioner(String id, String name) {
        super(id, name);
    }

    @Override
    public void setUpWifi() {
        System.out.println(this.getName() + " connected to wifi");
    }
}
