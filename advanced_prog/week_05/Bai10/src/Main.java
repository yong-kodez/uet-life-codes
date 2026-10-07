import java.util.Scanner;
import java.util.HashMap;

import java.io.FileReader;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Path to config file: ");
        String path = sc.next();

        FileReader fr = null;
        BufferedReader br = null;
        String line = "";
        HashMap<String, String> map = new HashMap<>();

        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                String[] pair = line.split("=");
                map.put(pair[0], pair[1]);
            }            

            if (!((map.containsKey("username")) && (map.containsKey("timeout"))))
                throw new InvalidConfigException("must contains both \'username\' and \'timeout' property");

            for (String k : map.keySet()) {
                try {
                    if (k.equals("username")) {
                        System.out.println(" - username = " + map.get(k));
                    } else if (k.equals("timeout")) {
                        int t = Integer.parseInt(map.get(k));
                        if (t <= 0) throw new InvalidConfigException("\'timeout\' must > 0");

                        System.out.println(" - timeout = " + t);
                    } else if (k.equals("maxConnections")) {
                        int t = Integer.parseInt(map.get(k));
                        if (t < 1) throw new InvalidConfigException("\'maxConnections\' must >= 1");

                        System.out.println(" - maxConnections = " + t);
                    } else throw new InvalidConfigException("not a valid property");
                } catch (NumberFormatException e) {
                    throw new NumberFormatException();
                }
            }

            System.out.println("Config loaded successfully"); 
        } catch (FileNotFoundException e) {
            System.err.println("[!] Config file not found");
        } catch (NumberFormatException e) {
            System.err.println("[!] Invalid number format");
        } catch (InvalidConfigException e) {
            System.err.println("[!] Invalid config: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try { br.close(); }
                catch (IOException e) { e.printStackTrace(); }
            }
        }
        System.out.println("Program finished");
    }
}
