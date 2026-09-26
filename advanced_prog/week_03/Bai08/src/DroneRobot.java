public class DroneRobot extends Robot implements Flyable, GPS, ElectronicDevice {
    public DroneRobot(int id, String name) {
        super(id, name);
    }

    public void fly() {
        System.out.println(this.getName() + " flying");
    }

    public void getCoordinates() {
        System.out.println(this.getName() + " getting coordinates");
    }

    public void turnOn() {
        System.out.println(this.getName() + " turning on");
    }

    public void performMainTask() {
        System.out.println(this.getName() + " perfomming main tasks");
    }
}
