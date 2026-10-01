import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of employees: ");
        int n = sc.nextInt();
        Employee[] es = new Employee[n];
        System.out.println("(type/name/[baseSalary][bonus][penalty]-[workingHours][hourlyRate])");

        for (int i = 0; i < n; i++) {
            System.out.print(" - Employee " + (i+1) + ": ");
            String type = sc.next();
            String name = sc.next();

            if ("F".equals(type)) {
                double base_salary = sc.nextDouble();
                double bonus = sc.nextDouble();
                double pen = sc.nextDouble();
                es[i] =  new FullTimeEmployee("" + (i+1), name,
                                              base_salary, bonus, pen);
            } else if ("P".equals(type)) {
                double working_hours = sc.nextDouble();
                double hourly_rate = sc.nextDouble();
                es[i] = new PartTimeEmployee("" + (i+1), name,
                                             working_hours, hourly_rate);
            }
        }
        printAll(es);
    }

    public static void printAll(Employee[] es) {
        String type;
        for (Employee e : es) {
            if (e instanceof PartTimeEmployee) type = "Part-time";
            else if (e instanceof FullTimeEmployee) type = "Full-time";
            else type = "unknown";
            System.out.println(e.getName() + " - " + type + " - " + e.calcSalary());
        }
    }
}
