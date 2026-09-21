public class Inventory {
    private Product[] items;

    public Inventory(Product[] initialItems) {
        this.items = initialItems;
    }

    public void printInv() {
        System.out.println("ID\tNAME\tPRICE");
        for (Product p : this.items) {
            System.out.println(p.getId() + "\t" +
                               p.getName() + "\t" +
                               p.getPrice());
        }
    }
}
