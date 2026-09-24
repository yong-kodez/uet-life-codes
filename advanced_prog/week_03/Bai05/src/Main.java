public class Main {
    public static void main(String[] args) {
        FullTimeEmployee f = new FullTimeEmployee("01", "tony", "01/01/2000", 100, 20, 15);
        PartTimeEmployee p = new PartTimeEmployee("02", "betty", "21/11/2222", 6, 10);        
        Employee[] es = {f, p};
        printAll(es);
    }

    public static void printAll(Employee[] es) {
        double salary;
        System.out.println("ID\tNAME\tDOB\t\tSALARY");
        for (Employee e : es) {
            System.out.println(e.getId() + "\t" + e.getName() + "\t" +
                               e.getDob() + "\t" + e.calcSalary());
        }
    }
}
