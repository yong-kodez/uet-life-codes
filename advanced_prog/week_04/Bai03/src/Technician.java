public class Technician extends Employee {
    private int overtimeHours;
    
    public Technician(String id, String name, double bs, int ot) {
        super(id, name, bs);
        this.overtimeHours = ot;
    }

    @Override
    public double calculatePay() {
        return this.getBaseSalary() + overtimeHours*20000;
    }
    
    @Override
    public void work() {
        System.out.println("Installing devices");
    }
}
