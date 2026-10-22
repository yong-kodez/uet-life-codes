public class MainBefore {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager("25020508", "tony", 2.8,
                                 "UET.CS2043", "Lập trình nâng cao", 3,
                                 5.0, 7.0, 8.0);
        manager.printTranscript();
    }
}

class StudentManager {
    private String studentId;
    private String name;
    private double gpa;

    private String courseId;
    private String courseName;
    private int credits;

    private double midtermScore;
    private double finalScore;
    private double assignmentScore;

    public StudentManager(String studentId, String name, double gpa,
                          String courseId, String courseName, int credits,
                          double midtermScore, double finalScore, double assignmentScore) {
        this.studentId = studentId; this.name = name; this.gpa = gpa;
        this.courseId = courseId; this.courseName = courseName; this.credits = credits;
        this.midtermScore = midtermScore; this.finalScore = finalScore;
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

    public void printTranscript() {
        System.out.println("Sinh viên: " + name + " (" + studentId + ")");
        System.out.println("Môn học: " + courseName + " (" + courseId + ") - " + credits + " tín chỉ");
        System.out.println("Điểm GK: " + midtermScore + " | Điểm CK: " + finalScore
                         + " | Điểm BT: " + assignmentScore);
        System.out.printf("Điểm tổng kết: %.1f - Học lực: %s%n",
                          calculateFinalGrade(), getAcademicStatus());
    }
}
