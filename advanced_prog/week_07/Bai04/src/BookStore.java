import java.util.Map;
import java.util.HashMap;

public class BookStore {
    private Map<String, Integer> stock;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public BookStore() {
        stock = new HashMap<>();
    }

    public void addBook(String title, int qty) {
        lock.writeLock().lock();
        try {
            System.out.println(" + Adding book in bulk...");
            if (stock.containsKey(title))
                stock.put(title, stock.get(title) + qty);
            else stock.put(title, qty);
        } finally { lock.writeLock().unlock(); }
    }

    public void borrow(String title, int qty) {
        lock.writeLock().lock();
        try {
            System.out.println(" - Borrowing some books...");
            int current = stock.get(title)
            if (qty > current) System.out.println(" - [!] Out of stock");
            else stock.put(title, current - qty);
        } finally { lock.writeLock().unlock(); }
    }

    public void getStock(String title) {
        lock.readLock().lock();
        try {
            System.out.println("[#] Reading stock...");
            System.out.println(" |__ " + title + ": " + stock.get(title) + " remains");
        } finally { lock.readLock().unlock(); }
    }
}
