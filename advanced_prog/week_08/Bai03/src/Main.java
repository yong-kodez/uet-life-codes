public class Main {
    // 1)
    // - Vấn đề của 'fuelLevel' và 'batteryPercent': không phải lớp con nào cũng dùng
    // cả hai thuộc tính này
    // - Giải pháp: Push Down Field, đẩy 'fuelLevel' xuống lớp trung gian FuelVehicle
    // để hai Car và MortorBike dùng chung, và đẩy 'batteryLevel' xuống ElectricCar
    
    // 2)
    // - Vấn đề của getInfo(): đều bị lặp lại cấu trúc, chỉ khác loại ở đầu
    // - Giải pháp: Pull Up Method, đẩy getInfo() lên lớp cha và tạo một hàm getVehicleType()
    // để lấy loại của lớp con và ghép vào chuỗi của getInfo()
    public static void main(String[] args) {
        Vehicle motor = new MotorBike("29-AB", "Honda");
        Vehicle car = new Car("36-A1", "Porche");
        Vehicle electricCar = new ElectricCar("15-AH", "Tesla");

        System.out.println(motor.getInfo());
        System.out.println(car.getInfo());
        System.out.println(electricCar.getInfo());
    }
}

abstract class Vehicle {
    protected String plate;
    protected String brand;
    public Vehicle(String plate, String brand) {
        this.plate = plate;
        this.brand = brand;
    }
    public String getInfo() { return getVehicleType() + " [" + plate + "] - " + brand; }
    public abstract String getVehicleType();
}

abstract class FuelVehicle extends Vehicle {
    protected double fuelLevel;
    public FuelVehicle(String plate, String brand) {
        super(plate, brand);
        this.fuelLevel = 0;
    } 
    public void refuel(double liters) { fuelLevel += liters; }
}

class MotorBike extends FuelVehicle {
    public MotorBike(String plate, String brand) {
        super(plate, brand);
    }
    @Override
    public String getVehicleType() {
        return "Xe máy";
    }
}

class Car extends FuelVehicle {
    public Car(String plate, String brand) {
        super(plate, brand);
    }
    @Override 
    public String getVehicleType() {
        return "Ô tô";
    }
}

class ElectricCar extends Vehicle {
    protected int batteryPercent;
    public ElectricCar(String plate, String brand) {
        super(plate, brand);
        this.batteryPercent = 0;
    }
    @Override 
    public String getVehicleType() {
        return "Xe điện";
    }
    public void charge(int percent) { batteryPercent += percent; }
}
