public class FullTimeEmployee extends Employee {
    private double baseSalary;
    private double bonus;
    private double penalty;

    public FullTimeEmployee(String id, String name, String dob,
                            double baseSalary, double bonus, double penalty) {
        super(id, name, dob);
        this.baseSalary = baseSalary;
        this.bonus = bonus;                        
        this.penalty = penalty;
    }

    public double calcSalary() {
        return (baseSalary + (bonus - penalty));
    }
}
