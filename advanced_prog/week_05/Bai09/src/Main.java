import java.util.Scanner;
import java.util.ArrayList;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.EOFException;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String file = "data/store.bin";
        ArrayList<Student> list = new ArrayList<>();

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        FileOutputStream fos = null;
        FileInputStream fis = null;

        System.out.println("----Taking in students----");
        System.out.println("Reading student info until \"END\"");
        while (true) {
            System.out.print(" - Student: ");
            String id = sc.next();
            if (id.equals("END")) break;
            String name = sc.next();
            double gpa = sc.nextDouble();
            list.add(new Student(id, name, gpa));
        }

        System.out.println();
        System.out.println("----Writing objects----");
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            for (Student s : list) {
                oos.writeObject(s); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try { oos.close(); }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println();
        System.out.println("----Reading objects----");
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            while (true) {
                Student s = (Student)(ois.readObject());
                System.out.println(" + " + s);
            }
        } catch (EOFException e) {
            System.out.println(" - Reached EOF");
        } catch (FileNotFoundException e) {
            System.err.println("[!] Destination file not found");
        } catch (ClassNotFoundException e) {
            System.err.println("[!] No class found");            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try { ois.close(); }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
