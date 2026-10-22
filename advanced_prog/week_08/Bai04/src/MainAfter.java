import java.util.ArrayList;
import java.util.List;

public class MainAfter {
    public static void main(String[] args) {
        Vehicle car = new Car("29-AB");
        Vehicle bike = new Bike("36-A1");
        Vehicle truck = new Truck("15-AH");

        ParkingCustomer customer = new ParkingCustomer("tony");
        customer.addTicket(new ParkingTicket(car, 3));
        customer.addTicket(new ParkingTicket(bike, 5));
        customer.addTicket(new ParkingTicket(truck, 10));

        System.out.println(customer.receipt());
    }
}

abstract class Vehicle {
    static final int CAR_BASE_FEE = 10;
    static final int BIKE_BASE_FEE = 5;
    static final int TRUCK_BASE_FEE = 15;

    static final int CAR_OVERTIME = 2;
    static final int BIKE_OVERTIME = 3;

    static final int CAR_HOURLY_RATE = 3;
    static final int BIKE_HOURLY_RATE = 2;
    static final int TRUCK_HOURLY_RATE = 4;
    static final int TRUCK_BONUS_THRESHOLD = 5;

    private final String plate;

    public Vehicle(String plate) {
        this.plate = plate;
    }
    public String getPlate() { return plate; }
    public abstract double getFee(int hours);
    public int getBonus(int hours) { return 1; }
}

class Car extends Vehicle {
    public Car(String plate) { super(plate); }
    @Override
    public double getFee(int hours) {
        double total = CAR_BASE_FEE;
        int overtime = 0;
        if ((overtime = (hours - CAR_OVERTIME)) > 0)
            total += overtime * CAR_HOURLY_RATE;
        return total;
    }
}
class Bike extends Vehicle {
    public Bike(String plate) { super(plate); }
    @Override 
    public double getFee(int hours) {
        double total = BIKE_BASE_FEE;
        int overtime = 0;
        if ((overtime = (hours - BIKE_OVERTIME)) > 0)
            total += overtime * BIKE_HOURLY_RATE;
        return total;
    }
}
class Truck extends Vehicle {
    public Truck(String plate) { super(plate); }
    @Override 
    public double getFee(int hours) {
        double total = TRUCK_BASE_FEE + hours * TRUCK_HOURLY_RATE;
        // if ((overtime = (hours - TRUCK_OVERTIME)) > 0)
        // total += (hours - overtime) * BIKE_HOURLY_RATE;
        return total;
    }
    public int getBonus(int hours) {
        int bonus = super.getBonus(hours);
        if (hours > TRUCK_BONUS_THRESHOLD)
            bonus++; 
        return bonus;
    }
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
    public double getFee() {
        return getVehicle().getFee(hours);
    }
    public int getBonus() {
        return getVehicle().getBonus(hours);
    }
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
            thisFee = each.getFee();

            totalFee += thisFee;
            bonusPoints += each.getBonus();

            result += "\t" + each.getVehicle().getPlate() + "\t" + thisFee + "\n";
        }

        result += "Total fee is " + totalFee + "\n";
        result += "You earned " + bonusPoints + " bonus points";
        return result;
    }
}
