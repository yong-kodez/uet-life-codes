import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of employees: ");
        int n = sc.nextInt();
        ArrayList<Employee> es = new ArrayList<>();
        System.out.println("(type/name/salary/[OT]-[bugs])");

        for (int i = 0; i < n; i++) {
            System.out.print(" * Employee " + (i+1) + ": ");
            String type = sc.next();
            String name = sc.next();
            double bs = sc.nextDouble();

            if ("D".equals(type)) {
                int ot = sc.nextInt();
                es.add(new Developer(name, bs, ot));                
            } else if ("T".equals(type)) {
                int bugs = sc.nextInt();
                es.add(new Tester(name, bs, bugs));                
            } else es.add(new Employee(name, bs));
        }
        System.out.println();
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
