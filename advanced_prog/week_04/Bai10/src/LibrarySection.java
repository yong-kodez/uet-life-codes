import java.util.ArrayList;

public class LibrarySection<T extends MediaItem> {
    private ArrayList<T> items;

    public LibrarySection() {
        this.items = new ArrayList<T>();
    }

    public void addItem(T doc) {
        this.items.add(doc);
    }
    public void removeItem(String id) {
        for (T item : items) {
            if (id.equals(item.getId()))
                this.items.remove(item); 
        }
    }
    public void detail() {
        for (T item : items) {
            System.out.println(item.detail());
        }
    }
}
