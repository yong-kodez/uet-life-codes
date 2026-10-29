import java.util.Map;
import java.util.HashMap;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BookStore {
    private Map<String, Integer> stock;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public BookStore() {
        stock = new HashMap<>();
    }

    public void restock(String title, int qty) {
        lock.writeLock().lock();
        try {
            System.out.println(" + Adding " + qty + " of: " + title);
            if (stock.containsKey(title))
                stock.put(title, stock.get(title) + qty);
            else stock.put(title, qty);
        } finally { lock.writeLock().unlock(); }
    }

    public void borrow(String title, int qty) {
        lock.writeLock().lock();
        try {
            System.out.println(" - Borrowing " + qty + " of: " + title);
            int current = stock.get(title);
            if (qty > current) System.out.println(" - [!] Out of stock");
            else stock.put(title, current - qty);
        } finally { lock.writeLock().unlock(); }
    }

    public void getStock(String title) {
        lock.readLock().lock();
        try {
            System.out.println("\t\t\t\t\t\t" + title + ": " + stock.get(title) + " remains");
        } finally { lock.readLock().unlock(); }
    }
}
