public class Tester extends Employee {
    private int bugsFound;

    public Tester(String name, double bs, int bugs) {
        super(name, bs);
        this.bugsFound = bugs;
    }

    @Override
    public double calculateBonus() {
        return this.getBaseSalary()*0.1 + bugsFound*50000;
    }
}
