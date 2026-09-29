import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of employees: ");
        int n = sc.nextInt();                
        Employee[] es = new Employee[n];

        System.out.println("(temp/id/name/baseSalary)");
        for (int i = 0; i < n; i++) {
            System.out.print("- Employee " + (i+1) + ": ");
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            double bs = sc.nextDouble();

            if ("O".equals(type)) es[i] = new OfficeWorker(id, name, bs);
            else if ("T".equals(type)) {
                int ot = sc.nextInt();
                es[i] = new Technician(id, name, bs, ot);
            }
        }
        allWork(es);
    }

    public static void allWork(Employee[] es) {
        double total = 0;
        for (Employee e : es) {
            System.out.println(e.getName() + " - Pay: " + e.calculatePay());
            e.work();
            System.out.println("");
            total += e.calculatePay();
        }
        System.out.println("-> Total pay = " + total);
    }
}
