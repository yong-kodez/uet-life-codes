import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("-> Enter number of products: ");
        int n = sc.nextInt();
        Product[] ps = new Product[n];
        
        for (int i = 1; i <= n; i++) {
            System.out.println("* Properties for product " + i + ":");

            System.out.print("  - Name: ");
            String name = sc.nextLine();
            sc.next();

            System.out.print("  - Price: ");
            double price = sc.nextDouble();

            System.out.print("  - Quantity: ");
            int quantity = sc.nextInt();

            System.out.print("  - Discount: ");
            double discount = sc.nextDouble();

            ps[i-1] = new Product(name, price, quantity, discount);
        }
        Product p1 = ps[0];
        Product p2 = ps[1];

        System.out.print("-> Enter buy quatity for p1: ");
        int q1 = sc.nextInt();
        System.out.print("-> Enter buy quatity for p2: ");
        int q2 = sc.nextInt();
        p1.sell(q1);
        p2.sell(q2);
       
        System.out.println("- Initial price");
        printPrice("p1", p1);
        printPrice("p2", p2);

        Product.updateTaxRate(0.08);
        System.out.println("- Tax rate = 0.08");
        printPrice("p1", p1);
        printPrice("p2", p2);

        p1.updateDiscount(10);
        System.out.println("- Product 1 discount = 10");
        printPrice("p1", p1);
        printPrice("p2", p2);
                
        Product.getTotal();
    }

    public static void printPrice(String name, Product p) {
        System.out.println("  + Price of " + name + ": " + p.calculateFinalPrice());
    }
}
