public class Main {
    public static void main(String[] args) {
        FullTimeEmployee f = new FullTimeEmployee("01", "tony", "01/01/2000", 1, 2, 3);
        PartTimeEmployee p = new PartTimeEmployee("01", "tony", "21/11/2222", 1, 2);        
        Employee[] es = {f, p};
        printAll(es);
    }

    public static void printAll(Employee[] es) {
        double salary;
        System.out.println("ID\tNAME\tDOB\t\tSALARY");
        for (Employee e : es) {
            if (e instanceof FullTimeEmployee)
                salary = ((FullTimeEmployee)e).calcSalary();
            else
                salary = ((PartTimeEmployee)e).calcSalary();

            System.out.println(e.getId() + "\t" + e.getName() + "\t" +
                               e.getDob() + "\t" + salary);
        }
    }
}
