public class Main {
    public static void main(String[] args) {
        CentralHub hub = new CentralHub();
                
        SmartLight l1 = new SmartLight("L01", "Living Room Light", 80);
        SmartLight l2 = new SmartLight("L02", "Bedroom Light");

        l2.setBrightness("ECO");
        l1.connectToHub(hub);
        l2.connectToHub(hub);
        
        System.out.println("- L01's brightness = " + l1.getBrightness());
        System.out.println("- L02's brightness = " + l2.getBrightness());
    }
}
