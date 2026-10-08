import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        

        System.out.print("Number of device: ");
        int n = sc.nextInt();
        OnOffDevice[] hub = new OnOffDevice[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print(" - Device " + (i+1) + ": ");
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            if ("L".equals(type)) hub[i] = new SmartLight(id, name);
            else if ("AC".equals(type)) hub[i] = new AirConditioner(id, name);
            else if ("S".equals(type)) hub[i] = new SmartSpeaker(id, name);
            else if ("C".equals(type)) hub[i] = new SmartCurtain(id, name);
        }

        System.out.println("Turn off all devices:");
        for (OnOffDevice d : hub) d.turnOff();

        System.out.println();
        System.out.println("Setup Wifi:");
        for (OnOffDevice d : hub) {
            if (d instanceof WifiConnectable)
                ((WifiConnectable)d).setUpWifi();
        }

    }
}
