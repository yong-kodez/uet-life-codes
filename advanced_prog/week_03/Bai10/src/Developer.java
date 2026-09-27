public class Developer extends Employee {
    private int overtimeHours;
    
    public Developer(String name, double bs, int ot) {
        super(name, bs);
        this.overtimeHours = ot;
    }

    @Override
    public double calculateBonus() {
        return this.getBaseSalary()*0.1 + overtimeHours*200000;
    }
}
