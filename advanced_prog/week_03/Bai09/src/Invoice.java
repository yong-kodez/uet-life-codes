public class Invoice implements IPayable {
    private String itemName;
    private int quantity;
    private double pricePerItem;
    
    public Invoice(String name, int quantity, double ppi) {
        this.itemName = name;
        this.quantity = quantity;
        this.pricePerItem = ppi;
    }

    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }
}
