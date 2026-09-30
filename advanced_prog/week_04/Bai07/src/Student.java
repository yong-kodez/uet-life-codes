public class Student {
    private String id;
    private String name;
    private double gpa;

    public Student() {
        this.id = "unknown";
        this.name = "unknown";
        this.gpa = -1;
    }
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.gpa = -1;
    }
    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    public Student(Student s) { this(s.id, s.name, s.gpa); }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    public String getId() { return this.id; }
    public String getName() { return this.name; }
    public double getGpa() { return this.gpa; }

    public void detail() {
        System.out.println(id + " " + name + " " + gpa);
    }
}
