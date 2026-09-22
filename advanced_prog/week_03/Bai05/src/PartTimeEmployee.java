public class PartTimeEmployee extends Employee {
    private double workingHours;
    private double hourlyRate;

    public PartTimeEmployee(String id, String name, String dob,
                            double workingHours, double hourlyRate) {
        super(id, name, dob);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;                        
    }
    public double calcSalary() {
        return workingHours * hourlyRate;
    }
}
