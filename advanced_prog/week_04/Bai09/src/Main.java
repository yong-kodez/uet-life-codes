import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory<Electronics> eStore = new Inventory<>();
        Inventory<Food> fStore = new Inventory<>();        

        System.out.print("Number of items: ");
        int n = sc.nextInt();
        System.out.println("(type-name-expiryDate/warrantyMonths)");

        for (int i = 0; i < n; i++) {
            System.out.print(" - Item " + (i+1) + ": ");
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            if ("F".equals(type)) {
                String exp = sc.next();
                fStore.addItem(new Food(id, name, exp));
            } else if ("E".equals(type)) {
                int wm = sc.nextInt();
                eStore.addItem(new Electronics(id, name, wm));
            }
        }
        System.out.println("* Food inventory");
        fStore.checkInventory();
        System.out.println();
        System.out.println("* Electronics inventory");
        eStore.checkInventory();
    }
}
