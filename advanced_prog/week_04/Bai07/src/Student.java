public class Student {
    private String id;
    private String name;
    private String email;
    private double gpa;

    public Student() {
        this.id = "unknown";
        this.name = "unknown";
        this.email = "unknown";
        this.gpa = -1;
    }
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.email = "unknown";
        this.gpa = -1;
    }
    public Student(String id, String name, String email, double gpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gpa = gpa;
    }
    public Student(Student s) { this(s.id, s.name, s.email, s.gpa); }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public boolean setGpa(double gpa) { this.gpa = gpa; }

    public String getId() { return this.id; }
    public String getName() { return this.name; }
    public String getEmail() { return this.email; }
    public double getGpa() { return this.gpa; }
}
