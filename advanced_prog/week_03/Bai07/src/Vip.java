public class Vip extends Room {
    public Vip(int nights) {
        super(nights);
        this.setPrice(2000000);
    }

    public double getFinalPrice() {
        return this.getPrice() * this.getNights();
    }
}
