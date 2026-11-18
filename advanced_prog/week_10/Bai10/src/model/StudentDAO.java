package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class StudentDAO {
    private static final String DB_URL = "jdbc:sqlite:data/student.db";    

    public static void initDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS students ("
                   + "student_id TEXT PRIMARY KEY, "
                   + "full_name TEXT NOT NULL, "
                   + "birth_date TEXT NOT NULL, "
                   + "gender TEXT NOT NULL, "
                   + "major TEXT NOT NULL, "
                   + "email TEXT NOT NULL"
                   + ");";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Database ready to go");
        } catch (SQLException e) {
            System.err.println("Error when initial database: " + e.getMessage());
        }
    }

    public static boolean saveStudent(Student s) throws SQLException {
        String sql = "INSERT OR REPLACE INTO students (student_id, full_name, birth_date, gender, major, email)"
                + "VALUES (?, ?, ?, ?, ?, ?);";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, s.getStudentId());
            pstmt.setString(2, s.getFullName());
            pstmt.setString(3, s.getBirthDate().toString());
            pstmt.setString(4, s.getGender());
            pstmt.setString(5, s.getMajor());
            pstmt.setString(6, s.getEmail());

            return pstmt.executeUpdate() > 0;
        }
    }

    public static Student getStudentById(String studentId) throws SQLException {
        String sql = "SELECT * FROM students WHERE student_id = ?;";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId);                 
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String id = rs.getString("student_id");
                String name = rs.getString("full_name");
                LocalDate dob = LocalDate.parse(rs.getString("birth_date"));
                String gender = rs.getString("gender");
                String major = rs.getString("major");
                String email = rs.getString("email");

                return new Student(id, name, dob, gender, major, email);
            }
        }
        return null;
    }
}
