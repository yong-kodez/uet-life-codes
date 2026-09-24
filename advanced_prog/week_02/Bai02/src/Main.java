public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("28082007", "Dũng");
        Student s3 = new Student("25020508", "Trần Ngọc Dũng", "25020508@vnu.edu.vn", (float)3.98);
        Student s4 = new Student(s3);
        Student[] ss = {s1, s2, s3, s4};
        
        s1.setId("007");
        s1.setName("Dũng Trần");

        gpaHdl(s2, s2.setGpa((float)5.2));
        gpaHdl(s2, s2.setGpa((float)-12));
        gpaHdl(s2, s2.setGpa((float)3.2));

        int i = 1;
        for (Student s : ss) {
            System.out.println("* Student s" + i);
            detail(s);
            i++;
        }
    }

    public static void detail(Student s) {
        System.out.println("  - ID: " + s.getId());
        System.out.println("  - Name: " + s.getName());
        System.out.println("  - Email: " + s.getEmail());
        System.out.println("  - GPA: " + s.getGpa());
    }

    public static void gpaHdl(Student s, boolean b) {
        String fmt = "* Setting GPA for " + s.getId() + "\n";
        if (b) fmt += "  + Setting complete";
        else fmt += "  [!] Invalid value: must be in range [0.0;4.0], negate change";
        System.out.println(fmt);
    }
}
