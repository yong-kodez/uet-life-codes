import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerQueue queue = new CustomerQueue();

        System.out.println(" - Customer A ordering...");
        queue.addCustomer(new Customer("NguyenVanA"));
        System.out.println("   >> Success");

        System.out.println(" - Customer B ordering...");
        queue.addCustomer(new Customer("TranThiB"));
        System.out.println("   >> Success");
        
        Customer c1 = handleCustomer(queue);
        MessageHistory m1 = handleMessage(c1, sc);

        System.out.println("(Last message before undo: " + m1.viewLast() + ")");
        m1.undo();
        System.out.println("(Last message after undo: " + m1.viewLast() + ")");
        System.out.println("   >> Done for " + c1.getName());
        // m1.undo();
        // m1.undo();
        // m1.undo();
                
        Customer c2 = handleCustomer(queue);

        handleCustomer(queue);
    }

    public static Customer handleCustomer(CustomerQueue q) {
        Customer c = q.getCustomer();
        if (c == null) {
            System.out.println("[!] Warning: No more customer in queue");
            return null;
        }
        System.out.println(" + Handling customer " + c.getName()); 
        return c;
    }

    public static MessageHistory handleMessage(Customer c, Scanner sc) {
        MessageHistory mh = new MessageHistory();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;

            mh.addMessage(new Message(line));
        }
        return mh;
    }
}
