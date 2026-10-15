import java.io.DataInputStream;
import java.io.FileInputStream;

import java.io.EOFException;
import java.io.IOException;

public class ReadProgram {
    public static void main(String[] args) {
        System.out.println("----Read Program----");

        String src = "data/numbers.bin";
        DataInputStream dis = null;
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(src);
            dis = new DataInputStream(fis);
            int n = 0;

            while (true) {
                n = dis.readInt();
                System.out.println(" + Read: " + n); 
            }

        } catch (EOFException e) {
            System.out.println(" - Reached EOF");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try { fis.close(); }
                catch (IOException e) { e.printStackTrace(); }
            }
        }
    }
}
