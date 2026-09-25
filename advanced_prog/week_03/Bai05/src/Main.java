import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of employees: ");
        int n = sc.nextInt();
        Employee[] es = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println(" * Employee " + (i+1));
            System.out.print("  - Employee type (F/P): ");
            String type = sc.next();

            System.out.print("  - Name: ");
            String name = sc.next();

            System.out.print("  - Dob: ");
            String dob = sc.next();

            if ("F".equals(type)) {
                System.out.print("    + base salary: ");
                double base_salary = sc.nextDouble();
                System.out.print("    + bonus: ");
                double bonus = sc.nextDouble();
                System.out.print("    + penalty: ");
                double pen = sc.nextDouble();

                es[i] =  new FullTimeEmployee("" + (i+1), name, dob,
                                              base_salary, bonus, pen);
            } else if ("P".equals(type)) {
                System.out.print("    + working hours: ");
                double working_hours = sc.nextDouble();
                System.out.print("    + hourly rate: ");
                double hourly_rate = sc.nextDouble();

                es[i] = new PartTimeEmployee("" + (i+1), name, dob,
                                             working_hours, hourly_rate);
            }
        }
        printAll(es);
    }

    public static void printAll(Employee[] es) {
        double salary;
        String type;
        System.out.println("ID\tNAME\tDOB\t\tTYPE\t\tSALARY");
        for (Employee e : es) {
            if (e instanceof PartTimeEmployee) type = "Part time";
            else if (e instanceof FullTimeEmployee) type = "Full time";
            else type = "unknown";
            System.out.println(e.getId() + "\t" + e.getName() + "\t" +
                               e.getDob() + "\t" + type + "\t" + e.calcSalary());
        }
    }
}
