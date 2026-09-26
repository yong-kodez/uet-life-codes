public class AmphibiousRobot extends Robot implements Flyable, Swimmable, GPS {
    public AmphibiousRobot(int id, String modelName) {
        super(id, modelName);
    }

    public void fly() {
        System.out.println(this.getName() + " flying");
    }
    public void swim() {
        System.out.println(this.getName() + " swimming");
    }
    public void getCoordinates() {
        System.out.println(this.getName() + " getting coordinates");
    }

    public void performMainTask() {
        System.out.println(this.getName() + " perfomming main tasks");
    }
}
