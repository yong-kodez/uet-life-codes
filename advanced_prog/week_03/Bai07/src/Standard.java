public class Standard extends Room {
    public Standard(int nights) {
        super(nights);
        this.setPrice(500000);
    }    

    public double getFinalPrice() {
        double finalPrice = super.getPrice() * super.getNights();
        if (this.getNights() > 3)
            finalPrice *= 0.95;
        return finalPrice;
    }
}
