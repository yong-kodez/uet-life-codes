import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of employees: ");
        int n = sc.nextInt();
        ArrayList<Employee> es = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            System.out.print(" * Employee " + (i+1) + " (type/name/salary/ot-bugs): ");
            // System.out.print("  - Type (E/D/T): ");
            String type = sc.next();

            // System.out.print("  - Name: ");
            String name = sc.next();

            // System.out.print("  - Base salary: ");
            double bs = sc.nextDouble();

            if ("D".equals(type)) {
                // System.out.print("  - Overtime hours: ");
                int ot = sc.nextInt();
                es.add(new Developer(name, bs, ot));                
            } else if ("T".equals(type)) {
                // System.out.print("  - Bugs found: ");
                int bugs = sc.nextInt();
                es.add(new Tester(name, bs, bugs));                
            } else es.add(new Employee(name, bs));
        }
        printAll(es);
    }

    public static void printAll(ArrayList<Employee> es) {
        String type = "Employee";
        String gift = "";

        for (Employee e : es) {
            if (e instanceof Developer) gift = "Gifted AWS course";
            else if (e instanceof Tester) gift = "Gifted tool Test";                

            System.out.println(e.getName() + " - Bonus: " + e.calculateBonus());
            if (!("".equals(gift))) System.out.println(gift);
            System.out.println("");
        }
    }
}
