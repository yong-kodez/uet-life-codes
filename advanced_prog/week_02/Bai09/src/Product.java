public class Product {
    private String name;
    private double price;
    private int quantity;
    private double discount;
    
    private static double taxRate = 0.1;
    private static double totalRevenue = 0;

    public Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public static void updateTaxRate(double newRate) {
        taxRate = newRate;
    }

    public double calculateFinalPrice() {
        return ((price - discount) * (1 + taxRate));
    }

    public void updateDiscount(double newDiscount) {
        this.discount = newDiscount;
    }

    public void sell(int amount) {
        if (amount <= quantity) {
            totalRevenue = amount * calculateFinalPrice();
        } else System.err.println("[ERR] Not enough quantity in inventory!");        
    }

    public static double getTotal() { return totalRevenue; }
}
