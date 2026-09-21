public class Product {
    private String id;
    private String name;
    private double price;
   
    private static int time = 1;
    
    public Product(String name, double price) {
        this.id = "" + time;
        this.name = name;
        this.price = price;
        time++;
    }

    public String getId() { return this.id; }
    public String getName() { return this.name; }
    public double getPrice() { return this.price; }

    public boolean setPrice(double price) {
        if (price < 0) return false;
        this.price = price;
        return true;
    }
}
