import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        PrintWriter pw = null;
        
        System.out.print("src: ");
        String src = sc.next();
        System.out.print("des: ");
        String des = sc.next();
        
        String line = "";
        ArrayList<String> lines = new ArrayList<>();

        try {
            fr = new FileReader(src);            
            br = new BufferedReader(fr);
            while ((line = br.readLine()) != null)
                lines.add(line);

        } catch (FileNotFoundException e) {
            System.out.println("[!] Source file not found");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try { br.close(); }
                catch (IOException e) {
                    e.printStackTrace();
                }
        }

        try {
            fw = new FileWriter(des);
            pw = new PrintWriter(fw);
            int n = 0;
            for (String l : lines) {
                pw.println(l);
                n++;
            }
            System.out.println(" - Copy success: " + n + " line(s)");

        } catch (FileNotFoundException e) {
            System.out.println("[!] Cannot create destination file");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null)
                try { fw.close(); }
                catch (IOException e) {
                    e.printStackTrace();
                }
        }
    } 
}
