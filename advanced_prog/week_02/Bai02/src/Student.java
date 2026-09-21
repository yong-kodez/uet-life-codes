public class Student {
    private String id;
    private String name;
    private String email;
    private float gpa;

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

    public Student(String id, String name, String email, float gpa) {
        if (gpa > 0.0 && gpa <= 4.0) this.gpa = gpa;
        else this.gpa = -1;        

        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Student(Student s) {
        this(s.id, s.name, s.email, s.gpa);
    }

    public void setId(String id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setEmail(String email) { this.email = email; }

    public boolean setGpa(float gpa) {
        if (gpa < 0.0 || gpa > 4.0) return false;
        this.gpa = gpa;
        return true;
    }

    public String getId() { return this.id; }
    public String getName() { return this.name; }
    public String getEmail() { return this.email; }
    public float getGpa() { return this.gpa; }
}
