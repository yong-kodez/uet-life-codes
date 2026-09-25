import java.time.LocalDate;

public class Food extends Product {
    private LocalDate expiryDate;

    public Food(String name, double price, LocalDate expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    public double getFinalPrice() {
        LocalDate today = LocalDate.now();
        LocalDate later = today.plusDays(7);
        boolean notExp = this.expiryDate.isAfter(today) || this.expiryDate.isEqual(today);
        boolean almostExp = later.isAfter(this.expiryDate);

        if (notExp && almostExp) { return this.getInitPrice() * 0.8; }
        return this.getInitPrice();
    }
}
