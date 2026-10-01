public class DroneRobot extends Robot implements Flyable, GPS, ElectronicDevice {
    public DroneRobot(int id, String name) {
        super(id, name);
    }

    @Override
    public void fly() {
        System.out.println(this.getName() + " flying");
    }

    @Override
    public void getCoordinates() {
        System.out.println(this.getName() + " getting coordinates");
    }

    @Override
    public void turnOn() {
        System.out.println(this.getName() + " turning on");
    }

    @Override
    public void performMainTask() {
        System.out.println(this.getName() + " perfomming main tasks");
    }
}
