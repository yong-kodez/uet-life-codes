import java.util.Scanner;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

import java.io.EOFException;
import java.io.IOException;
import java.util.InputMismatchException;

public class WriteProgram {
    public static void main(String[] args) {
        System.out.println("----Write Program----");

        Scanner sc = new Scanner(System.in);
        String des = "data/numbers.bin";
        DataOutputStream dos = null;
        FileOutputStream fos = null;

        System.out.print("Numbers to write: ");
        int n = sc.nextInt();

        try {
            fos = new FileOutputStream(des);
            dos = new DataOutputStream(fos);

            System.out.print("  --> Enter numbers: ");
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();                
                dos.writeInt(num);
            }            

        } catch(InputMismatchException e) {
            System.out.println("[!] Input must be integers");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try { fos.close(); }
                catch (IOException e) { e.printStackTrace(); }
            }
        }
    }
}
