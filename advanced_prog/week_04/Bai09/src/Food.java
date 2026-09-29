public class Food extends Product {
    private String expiryDate;

    public Food(String id, String name, String expiryDate) {
        super(id, name);
        this.expiryDate = expiryDate;
    }
    public Food(Food o) {
        this(o.getId(), o.getName(), o.getExpiryDate());
    }

    public String getExpiryDate() { return this.expiryDate; }

    @Override
    public String detail() {
        return super.detail() + this.expiryDate;
    }
}
