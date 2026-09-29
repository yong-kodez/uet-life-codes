import java.util.ArrayList;

public class Inventory<T extends Product> {
    private ArrayList<T> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        this.items.add(item);
    }

    public T exportItem(String id) {
        for (T item : items) {
            if (item.getId().equals(id)) {
                this.items.remove(item);
                return item;
            }
        }
        return null;
    }

    public void checkInventory() {
        for (T item : items) {
            System.out.println(item.detail());
        }
    }
}
