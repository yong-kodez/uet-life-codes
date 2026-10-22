public class MainAfter {
    public static void main(String args[]) {
        Order standard = new StandardOrder(50, 1000);
        Order express = new ExpressOrder(30, 400);
        Order fragile = new FragileOrder(60, 600);
        Order bulky = new BulkyOrder(100, 500);

        System.out.println("STANDARD: " + standard.getDeliveryFee());
        System.out.println("EXPRESS: " + express.getDeliveryFee());
        System.out.println("FRAGILE: " + fragile.getDeliveryFee());
        System.out.println("BULKY: " + bulky.getDeliveryFee());
    }
}

abstract class Order {
    static final double STANDARD_WEIGHT_FEE = 3000;
    static final double EXPRESS_WEIGHT_FEE = 3000;
    static final double FRAGILE_WEIGHT_FEE = 5000;
    static final double BULKY_WEIGHT_FEE = 4000;

    static final double STANDARD_DISTANCE_FEE = 500;
    static final double EXPRESS_DISTANCE_FEE = 500;
    static final double FRAGILE_DISTANCE_FEE = 700;
    static final double BULKY_DISTANCE_FEE = 600;

    static final double EXPRESS_EXTRA_RATE = 1.5;
    static final int FRAGILE_EXTRA_FEE = 20000;
    static final int BULKY_EXTRA_FEE = 50000;

    private double weight;
    private double distance;

    public Order(double weight, double distance) {
        this.weight = weight; this.distance = distance;
    }
    public double getWeight() { return this.weight; }
    public double getDistance() { return this.distance; }

    public abstract double getDeliveryFee();
    public abstract String getLabel();
}
class StandardOrder extends Order {
    public StandardOrder(double weight, double distance) {
        super(weight, distance);
    }
    @Override
    public double getDeliveryFee() {
        return getWeight() * STANDARD_WEIGHT_FEE + getDistance() * STANDARD_DISTANCE_FEE;
   }
   @Override
   public String getLabel() {
       return "[THƯỜNG]";
   }
}
class ExpressOrder extends Order {
    public ExpressOrder(double weight, double distance) { super(weight, distance); }
    @Override
    public double getDeliveryFee() {
        return (getWeight() * EXPRESS_WEIGHT_FEE + getDistance() * EXPRESS_DISTANCE_FEE) * EXPRESS_EXTRA_RATE;
   }
   @Override
   public String getLabel() {
       return "[HỎA TỐC]";
   }
}
class FragileOrder extends Order {
    public FragileOrder(double weight, double distance) { super(weight, distance); }
    @Override
    public double getDeliveryFee() {
        return getWeight() * FRAGILE_WEIGHT_FEE + getDistance() * FRAGILE_DISTANCE_FEE + FRAGILE_EXTRA_FEE;
   }
   @Override
   public String getLabel() {
       return "[HÀNG DỄ VỠ]";
   }
}
class BulkyOrder extends Order {
    public BulkyOrder(double weight, double distance) { super(weight, distance); }
    @Override
    public double getDeliveryFee() {
        return getWeight() * BULKY_WEIGHT_FEE + getDistance() * BULKY_DISTANCE_FEE + BULKY_EXTRA_FEE;
   }
   @Override
   public String getLabel() {
       return "[HÀNG CỒNG KỀNH]";
   }
}
