public class Electronics extends Product {
    private int warrantyMonths;

    public Electronics(String id, String name, int wm) {
        super(id, name);
        this.warrantyMonths = wm;
    }
    public Electronics(Electronics o) {
        this(o.getId(), o.getName(), o.getWarrantyMonths());
    }

    public int getWarrantyMonths() { return this.warrantyMonths; }

    @Override
    public String detail() {
        return super.detail() + this.warrantyMonths + " warranty months";
    }
}
