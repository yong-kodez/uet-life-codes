import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.EOFException;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Handler {
    public static ObjectInputStream openRead(String src) {
        try {
            FileInputStream fis = new FileInputStream(src);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return ois;
        } catch (FileNotFoundExcpetion e) {
            System.err.println("[!] File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("[!] IO Exception");
            e.printStackTrace();
        }
    }

    public static ObjectOutputStream openWrite(String des) {
        try {
            FileOutputStream fos = new FileOutputStream(des);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            return oos;
        } catch (FileNotFoundExcpetion e) {
            System.err.println("[!] File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("[!] IO Exception");
            e.printStackTrace();
        }
    }
      
    public static void write(String des, Object o) {
        try {
            ObjectOutputStream oos = openWrite(des);
            oos.writeObject(o);
        } catch (ClassNotFoundExcpetion e) {
            System.err.println("[!] Class not found");
        } catch (IOException e) {
            System.err.println("[!] IO Exception");
            e.printStackTrace();
        }
    }

}
