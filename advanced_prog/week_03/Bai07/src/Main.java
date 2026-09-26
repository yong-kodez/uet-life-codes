import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        System.out.print("Number of rooms: ");
        int n = sc.nextInt();
        Room[] rs = new Room[n];

        for (int i = 0; i < n; i++) {
            System.out.println("* Room no " + (i+1));
            System.out.print("  - Type: ");
            String type = sc.next();

            System.out.print("  - Nights stay: ");
            int nights = sc.nextInt();

            if ("S".equals(type)) rs[i] = new Standard(nights);
            else if ("V".equals(type)) rs[i] = new Vip(nights);
        }
        printRooms(rs);
    }

    public static void printRooms(Room[] rs) {
        System.out.println("Bills");
        String type = "unknown";
        
        for (Room r : rs) {
            if (r instanceof Standard) type = "Standard";
            else if (r instanceof Vip) type = "Vip";
            System.out.println("  - Total of " + type +
                               " (" + r.getNights() + " nights)" +
                               ": " + r.getFinalPrice());
        }
    }
}
