public class AmphibiousRobot extends Robot implements Flyable, Swimmable, GPS {
    public AmphibiousRobot(int id, String modelName) {
        super(id, modelName);
    }

    @Override
    public void fly() {
        System.out.println(this.getName() + " flying");
    }

    @Override
    public void swim() {
        System.out.println(this.getName() + " swimming");
    }

    @Override
    public void getCoordinates() {
        System.out.println(this.getName() + " getting coordinates");
    }

    @Override
    public void performMainTask() {
        System.out.println(this.getName() + " perfomming main tasks");
    }
}
