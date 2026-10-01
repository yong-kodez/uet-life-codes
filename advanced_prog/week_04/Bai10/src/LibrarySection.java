import java.util.ArrayList;

public class LibrarySection<T extends MediaItem> {
    private ArrayList<T> items;

    public LibrarySection() {
        this.items = new ArrayList<T>();
    }

    public void addItem(T doc) {
        this.items.add(doc);
    }
    public void removeItem(T doc) {
        this.items.remove(doc);
    }
    public void detail() {
        String fmt = "";
        for (T item : items) {
            fmt = "";
            fmt += item.getName() + " - ";
            if (item instanceof Book) {
                Book b = (Book)item;
                fmt += b.getAuthor() + " - " + b.getPages();
            } else if (item instanceof Dvd) {
                Dvd d = (Dvd)item;
                fmt += d.getDirector() + " - " + d.getDuration();
            }
            System.out.println(fmt);
        }
    }
}
