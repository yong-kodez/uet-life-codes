import java.io.Serializable;

public class Student implements Serializable {
    private String id;
    private String name;
    private double gpa;
    
    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }    

    @Override
    public String toString() {
        return "Student: " + id + " - " + name + " - " + gpa;
    }
}
