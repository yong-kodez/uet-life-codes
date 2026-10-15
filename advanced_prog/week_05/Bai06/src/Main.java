import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("a = ");
            int a = sc.nextInt();
            System.out.print("b = ");
            int b = sc.nextInt();

            int result = a / b;            
            System.out.println("-> " + result);
        } catch (InputMismatchException ime) {
            System.out.println("[!] Input must be integers");  
        } catch (ArithmeticException ae) {
            System.out.println("[!] Cannot devide by 0");
        } finally {
            System.out.println("Program finished");
        }
    }
}
