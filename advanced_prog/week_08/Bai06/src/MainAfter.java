public class MainAfter {
    public static void main(String args[]) {
        Student student = new Student("25020508", "tony", 2.8);
        Course advanced_programming = new Course("UET.CS2043", "Lập trình nâng cao", 3);
        CourseScore score = new CourseScore(5.0, 7.0, 8.0);
        StudentManager manager = new StudentManager(student, advanced_programming, score);
        manager.printTranscript();
    }
}

class Student {
    private String studentId;
    private String name;
    private double gpa;

    public Student(String studentId, String name, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.gpa = gpa;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }
}
class Course {
    private String courseId;
    private String courseName;
    private int credits;

    public Course(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }
}
class CourseScore {
    private double midtermScore;
    private double finalScore;
    private double assignmentScore;

    public CourseScore(double midtermScore, double finalScore, double assignmentScore) {
        this.midtermScore = midtermScore;
        this.finalScore = finalScore;
        this.assignmentScore = assignmentScore;
    }

    public double calculateFinalGrade() {
        return assignmentScore * 0.2 + midtermScore * 0.3 + finalScore * 0.5;
    }

    public String getAcademicStatus() {
        double grade = calculateFinalGrade();
        if (grade >= 8.5) return "Giỏi";
        if (grade >= 7.0) return "Khá";
        if (grade >= 5.5) return "Trung bình";
        return "Yếu";
    }

    public double getMidtermScore() { return midtermScore; }
    public double getFinalScore() { return finalScore; }
    public double getAssignmentScore() { return assignmentScore; }
}
class StudentManager {
    private Student student;
    private Course course;
    private CourseScore score;

    public StudentManager(Student student, Course course, CourseScore score) {
        this.student = student;
        this.course = course;
        this.score = score;
    }
    
    public void printTranscript() {
        System.out.println("Sinh viên: " + student.getName() + " (" + student.getStudentId() + ")");
        System.out.println("Môn học: " + course.getCourseName() + " (" + course.getCourseId() + ") - " + course.getCredits() + " tín chỉ");
        System.out.println("Điểm GK: " + score.getMidtermScore() + " | Điểm CK: " + score.getFinalScore()
                         + " | Điểm BT: " + score.getAssignmentScore());
        System.out.printf("Điểm tổng kết: %.1f - Học lực: %s%n",
                          score.calculateFinalGrade(), score.getAcademicStatus());
    }
}
