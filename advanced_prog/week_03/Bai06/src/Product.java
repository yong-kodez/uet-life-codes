public abstract class Product {
    private String id;
    private String name;
    private double price;

    public static int time = 1;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.id = "" + time;
        time++;
    }
    
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    
    public String getId() { return this.id; }
    public String getName() { return this.name; }
    public double getInitPrice() { return this.price; }

    public abstract double getFinalPrice();
}
