public class PartTimeStaff extends Staff {
    private int workingHours;
    private double hourlyRate;

    public PartTimeStaff(String id, String name, int hours, double rate) {
        super(id, name);
        this.workingHours = hours;
        this.hourlyRate = rate;
    }

    @Override
    public double getPaymentAmount() {
        return workingHours * hourlyRate;
    }
}
