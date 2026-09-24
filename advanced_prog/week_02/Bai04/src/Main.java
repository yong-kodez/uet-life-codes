public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("tony", 1, 1, 2000);
        Employee e2 = new Employee(e1);

        System.out.println("* Employee e1:");
        detail(e1);
        System.out.println("* Employee e2:");
        detail(e2);
        
        if (e1.getDob().setDate(2, 2, 2022)) {
            System.out.println("\n-> Set e1's dob to 2/2/2022");
        } else System.out.println(" [!] Invalid date: ignore change");

        System.out.println("\n--------After----------");
        System.out.println("* Employee e1:");
        detail(e1);
        System.out.println("* Employee e2:");
        detail(e2);
    }

    public static void detail(Employee e) {
        MyDate dt = e.getDob();
        System.out.println("  - Name: " + e.getName());
        System.out.println("  - DoB: " + dt.getDay() +
                           "/" + dt.getMonth() +
                           "/" + dt.getYear());
    }
}
