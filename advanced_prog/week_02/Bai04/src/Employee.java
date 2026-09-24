public class Employee {
    private String name;
    private MyDate dob;

    public Employee(String name, MyDate dob) {
        this.name = name;
        this.dob = new MyDate(dob);        
    }

    public Employee(String name, int d, int m, int y) {
        this.name = name;
        this.dob = new MyDate(d, m, y);
    }

    public Employee(Employee e) {
        this.name = e.name;
        this.dob = new MyDate(e.dob);
        // this.dob = e.getDob();
    }

    public String getName() { return name; }
    public MyDate getDob() { return dob; }
}
