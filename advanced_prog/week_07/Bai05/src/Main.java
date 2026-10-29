import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Service service = new Service(4);
        System.out.print("Numer of packages/tasks: ");
        service.assignTasks(sc.nextInt());
        service.active();

        service.printLog();
        System.out.println(" -> Success = " + service.getSuccess());
        
        sc.close();
    }
}
