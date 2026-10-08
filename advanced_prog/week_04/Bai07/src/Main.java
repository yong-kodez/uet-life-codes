import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Operation<Double> add = (a, b) -> a+b;
        Operation<Double> sub = (a, b) -> a-b;
        Operation<Double> mul = (a, b) -> a*b;
        Operation<Double> div = (a, b) -> a/b;

        Scanner sc = new Scanner(System.in);
        System.out.print("Number of students: ");
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print(" - Student " + (i+1) + ": ");
            String id = sc.next();
            String name = sc.next();
            double gpa = sc.nextDouble();
            students.add(new Student(id, name, gpa));
        }

        System.out.println("After removing < 5.0");
        students.removeIf(student -> student.getGpa() < 5.0);
        for (Student s : students) s.detail();

        System.out.println();
        System.out.println("After sorting by name");
        Collections.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        for (Student s : students) s.detail();
    }
}
