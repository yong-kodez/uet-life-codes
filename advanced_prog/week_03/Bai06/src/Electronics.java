public class Electronics extends Product {
    private double warrantyFee;
    public static double vat = 0.1;

    public Electronics(String name, double price, double warrantyFee) {
        super(name, price);
        this.warrantyFee = warrantyFee;
    }

    public double getFinalPrice() {
        return (this.getInitPrice() * (1 + vat)) + this.warrantyFee;
    }
}
