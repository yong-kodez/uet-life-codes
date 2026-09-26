public abstract class Robot {
    private int id;
    private String modelName;
    private int batteryLevel;

    public Robot(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
    }

    public int getId() { return this.id; }
    public String getName() { return this.modelName; }

    public void chargeBattery() {
        this.batteryLevel = 100;
    }

    public final void showIdentity() {
        System.out.println("  - ID: " + this.id);
        System.out.println("  - Model name: " + this.modelName);
    }

    public abstract void performMainTask();
}
