public abstract class Employee {
    private String id;
    private String name;
    private String dob;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return this.id; }
    public String getName() { return this.name; }
    public String getDob() { return this.dob; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDob(String dob) { this.dob = dob; } 

    public abstract double calcSalary();
}
