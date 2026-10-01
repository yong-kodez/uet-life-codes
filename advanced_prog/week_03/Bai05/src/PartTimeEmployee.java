public class PartTimeEmployee extends Employee {
    private double workingHours;
    private double hourlyRate;

    public PartTimeEmployee(String id, String name,
                            double workingHours, double hourlyRate) {
        super(id, name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;                        
    }

    @Override
    public double calcSalary() {
        return workingHours * hourlyRate;
    }
}
