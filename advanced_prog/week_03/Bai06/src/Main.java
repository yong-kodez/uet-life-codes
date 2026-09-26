import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Number in order: ");
        int n = sc.nextInt();
        Product[] order = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("* Product " + (i+1));
            System.out.print("  - Type: ");
            String type = sc.next();

            System.out.print("  - Name: ");
            String name = sc.next();

            System.out.print("  - Price: ");
            double price = sc.nextDouble();

            if ("E".equals(type)) {
                System.out.print("    + warranty fee: ");
                double warranty = sc.nextDouble();
                order[i] = new Electronics(name, price, warranty);
            } else if ("F".equals(type)) {
                System.out.print("    + expiry date (y/m/d): ");
                int year = sc.nextInt();
                int month = sc.nextInt();
                int day = sc.nextInt();
                LocalDate exp = LocalDate.of(year, month, day);
                order[i] = new Food(name, price, exp);
            } else {
                System.out.println("[!] Invalid type: skip product");
            }
        }                
        printOrder(order);
    }

    public static void printOrder(Product[] ps) {
        String type = "";
        double total = 0;
        for (Product p : ps) {
            if (p instanceof Electronics) type = "Electronics";
            else if (p instanceof Food) type = "Food";
            else type = "unknown";

            System.out.println(p.getName() + " - " + type +
                               " - " + p.getFinalPrice());
            total += p.getFinalPrice();
        }
        System.out.println("--> Total = " + total);
    }
}
