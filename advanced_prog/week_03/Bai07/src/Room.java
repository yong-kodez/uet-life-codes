public abstract class Room {
    private double price = 0;
    private int nights;

    public Room(int nights) {
        this.nights = nights;
    }

    public double getPrice() { return this.price; }
    public int getNights() { return this.nights; }

    public void setPrice(double price) { this.price = price; } 

    public abstract double getFinalPrice();
}
