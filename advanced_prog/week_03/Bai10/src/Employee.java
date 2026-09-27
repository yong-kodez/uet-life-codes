public class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() { return this.name; }
    public double getBaseSalary() { return this.baseSalary; }

    public void setName(String name) { this.name = name; }
    public void setBaseSalary(double bs) { this.baseSalary = bs; }

    public double calculateBonus() {
        return baseSalary * 0.1;
    }
}
