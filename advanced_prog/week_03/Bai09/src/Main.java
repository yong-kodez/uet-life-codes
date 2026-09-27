import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number need payout: ");
        int n = sc.nextInt();
        IPayable[] ips = new IPayable[n];

        for (int i = 0; i < n; i++) {
            System.out.println(" * Object " + (i+1));
            System.out.print("  - Type (S/I): ");
            String type = sc.next();

            if ("S".equals(type)) {
                System.out.print("  - Properties (id/name/working hours/hourly rate): ");
                String id = sc.next();
                String name = sc.next();
                int hours = sc.nextInt();
                double rate = sc.nextDouble();
                ips[i] = new PartTimeStaff(id, name, hours, rate);
            } else if ("I".equals(type)) {
                System.out.print("  - Properties (item name/quantity/price per item): ");
                String itemName = sc.next();
                int quantity = sc.nextInt();
                double ppi = sc.nextDouble();
                ips[i] = new Invoice(itemName, quantity, ppi);
            }
        }
        printAllPayment(ips);
        
    }

    public static void printAllPayment(IPayable[] ips) {
        String type = "";
        String name = "";
        double total = 0;
        
        for (IPayable ip : ips) {
            if (ip instanceof PartTimeStaff) {
                type = "PartTimeStaff";
                PartTimeStaff pts = (PartTimeStaff) ip;
                name = pts.getName();
            } else if (ip instanceof Invoice) {
                type = "Invoice";
                Invoice iv = (Invoice) ip;
                name = iv.getName();
            }
            total += ip.getPaymentAmount();
            System.out.println(type + " " + name + " - Payment: "
                               + ip.getPaymentAmount());
        }
        System.out.println("Total Payment = " + total);
    }
}
