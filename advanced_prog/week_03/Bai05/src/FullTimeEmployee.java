public class FullTimeEmployee extends Employee {
    private double baseSalary;
    private double bonus;
    private double penalty;

    public FullTimeEmployee(String id, String name,
                            double baseSalary, double bonus, double penalty) {
        super(id, name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;                        
        this.penalty = penalty;
    }

    @Override
    public double calcSalary() {
        return (baseSalary + (bonus - penalty));
    }
}
