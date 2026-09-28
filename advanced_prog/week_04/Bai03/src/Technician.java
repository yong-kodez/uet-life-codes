public class Technician extends Employee {
    private int overtimeHours;
    
    public Technician(String id, String name, double bs) {
        super(id, name, bs);
    }

    @Override
    public double calculateSalary() {
        return this.getBaseSalary() + overtimeHours*20000;
    }
    
    @Override
    public void work() {
        System.out.println("Installing devices")
    }
}
