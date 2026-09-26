import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of robots: ");
        int n = sc.nextInt();
        Robot[] rs = new Robot[n];

        for (int i = 0; i < n; i++) {
            System.out.print(" - Robot " + (i+1) + " (type/id/modelName): ");
            String type = sc.next();
            int id = sc.nextInt();
            String name = sc.next();

            if ("DR".equals(type)) rs[i] = new DroneRobot(id, name);
            else if ("FR".equals(type)) rs[i] = new FishRobot(id, name);
            else if ("AR".equals(type)) rs[i] = new AmphibiousRobot(id, name);
        }
        performAllTask(rs);
    }

    public static void performAllTask(Robot[] rs) {
        for (Robot r : rs) {
            System.out.println("* Robot " + r.getId());
            if (r instanceof ElectronicDevice) {
                ElectronicDevice er = (ElectronicDevice) r;
                er.turnOn();
            }
            r.performMainTask();

            if (r instanceof Flyable) {
                Flyable fr = (Flyable) r;
                fr.fly();
            }
            if (r instanceof Swimmable) {
                Swimmable sr = (Swimmable) r;
                sr.swim();
            }
            if (r instanceof GPS) {
                GPS gr = (GPS) r;
                gr.getCoordinates();
            }
            System.out.println();
        }
    }
}
