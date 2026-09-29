public abstract class Employee implements IWorkable {
    private String id;
    private String name;
    private double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() { return this.baseSalary; }
    public String getName() { return this.name; }

    public abstract double calculatePay();
}
