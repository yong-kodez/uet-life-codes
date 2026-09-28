public class OfficeWorker extends Employee {
    public OfficeWorker(String id, String name, double bs) {
        super(id, name, bs);
    }

    @Override
    public double calculatePay() {
        return this.getBaseSalary();
    }

    @Override
    public void work() {
        System.out.println("Drafting documents");
    }
}
