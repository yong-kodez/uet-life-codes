package model;

import java.time.LocalDate;

public class Student {
    private String studentId;
    private String fullName;
    private LocalDate birthDate;
    private String gender;
    private String major;
    private String email;

    public Student(String studentId, String fullName, LocalDate birthDate, String gender, String major, String email) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.major = major;
        this.email = email;
    }

    public String getStudentId() { return studentId; }
    public String getFullName() { return fullName; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getGender() { return gender; }
    public String getMajor() { return major; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Student {" +
                "ID='" + studentId + '\'' +
                ", Tên='" + fullName + '\'' +
                ", Ngày sinh=" + birthDate +
                ", Giới tính='" + gender + '\'' +
                ", Ngành='" + major + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }
}
