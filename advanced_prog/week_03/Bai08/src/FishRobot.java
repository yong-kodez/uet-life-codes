public class FishRobot extends Robot implements Swimmable {
    public FishRobot(int id, String name) {
        super(id, name);
    }

    @Override
    public void swim() {
        System.out.println(this.getName() + " swimming");
    }

    @Override
    public void performMainTask() {
        System.out.println(this.getName() + " perfomming main tasks");
    }
}
