import java.util.ArrayList;
import java.util.List;

public class MainBefore {
    public static void main(String[] args) {
        Vehicle car = new Vehicle("29-AB", 0);
        Vehicle bike = new Vehicle("36-A1", 1);
        Vehicle truck = new Vehicle("15-AH", 2);

        ParkingCustomer customer = new ParkingCustomer("tony");
        customer.addTicket(new ParkingTicket(car, 3));
        customer.addTicket(new ParkingTicket(bike, 5));
        customer.addTicket(new ParkingTicket(truck, 10));

        System.out.println(customer.receipt());
    }
}

class Vehicle {
    static final int CAR = 0;
    static final int BIKE = 1;
    static final int TRUCK = 2;

    private final String plate;
    private final int type;

    public Vehicle(String plate, int type) {
        this.plate = plate;
        this.type = type;
    }
    public String getPlate() { return plate; }
    public int getType() { return type; }  
}

class ParkingTicket {
    private final Vehicle vehicle;
    private final int hours;

    public ParkingTicket(Vehicle vehicle, int hours) {
        this.vehicle = vehicle;
        this.hours = hours;
    }
    public Vehicle getVehicle() { return vehicle; }
    public int getHours() { return hours; }
}

class ParkingCustomer {
    private final String name;
    private final List<ParkingTicket> tickets = new ArrayList<>();

    public ParkingCustomer(String name) {
        this.name = name;
    }
    public void addTicket(ParkingTicket ticket) {
        tickets.add(ticket);
    }

    public String receipt() {
        double totalFee = 0;
        int bonusPoints = 0;
        String result = "Parking Receipt for " + name + "\n";

        for (ParkingTicket each : tickets) {
            double thisFee = 0;

            // calculate fee per ticket
            switch (each.getVehicle().getType()) {
                case Vehicle.CAR:
                    thisFee += 10;
                    if (each.getHours() > 2) {
                        thisFee += (each.getHours() - 2) * 3;
                    }
                    break;
                case Vehicle.BIKE:
                    thisFee += 5;
                    if (each.getHours() > 3) {
                        thisFee += (each.getHours() - 3) * 2;
                    }
                    break;
                case Vehicle.TRUCK:
                    thisFee += 15 + each.getHours() * 4;
                    break;
            }

            totalFee += thisFee;

            // bonus points
            bonusPoints++;
            if (each.getVehicle().getType() == Vehicle.TRUCK && each.getHours() > 5) {
                bonusPoints++;
            }

            result += "\t" + each.getVehicle().getPlate() + "\t" + thisFee + "\n";
        }

        result += "Total fee is " + totalFee + "\n";
        result += "You earned " + bonusPoints + " bonus points";
        return result;
    }
}
